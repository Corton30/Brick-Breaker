package mygame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;





public class GamePanel extends JPanel {
    private Paddle paddle;
    private Ball ball;
    private MapGenerator mapGenerator;
    private int currentLevel;
    private List<Brick> bricks;
    private int lives = 3;


    public GamePanel() {
        // Initialize the paddle
        paddle = new Paddle(650, 700, 150, 15);
        // Initialize the ball
        ball = new Ball(725, 600, 7,this);
        // Initialize the map generator
        mapGenerator = new MapGenerator();
        // Start with level 1

        currentLevel = 1;
        bricks = mapGenerator.generateMap(currentLevel);



        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if ((key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)&& paddle.getX() > 0){
                    paddle.moveLeft();
                    ball.startMoving();
                } else if ((key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)&& paddle.getX()+paddle.getWidth()<=1440) {
                    paddle.moveRight();
                    ball.startMoving();
                }
                else if (key == KeyEvent.VK_R) {
                    resetPaddle();
                    resetBall();
                }
                else if (key == KeyEvent.VK_1) {
                    currentLevel = 1;
                    bricks = mapGenerator.generateMap(currentLevel);
                    resetPaddle();
                    resetBall();
                }
                else if (key == KeyEvent.VK_2) {
                    currentLevel = 2;
                    bricks = mapGenerator.generateMap(currentLevel);
                    resetPaddle();
                    resetBall();
                }
                else if (key == KeyEvent.VK_3) {
                    currentLevel = 3;
                    bricks = mapGenerator.generateMap(currentLevel);
                    resetPaddle();
                    resetBall();
                }
                else if (key == KeyEvent.VK_4) {
                    currentLevel = 4;
                    bricks = mapGenerator.generateMap(currentLevel);
                    resetPaddle();
                    resetBall();
                }
                else if (key == KeyEvent.VK_5) {
                    currentLevel = 5;
                    bricks = mapGenerator.generateMap(currentLevel);
                    resetPaddle();
                    resetBall();
                }
                repaint();
            }
        });

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.update();
                // Check for collision with paddle
                paddle.BallHit(ball);

                // Check for collision with bricks
                for (Brick brick : bricks) {
                    if (brick.isHit(ball)) {
                        ball.reverseDirection();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    public void decrementLives() {
        lives--;
        resetPaddle();
        resetBall();
    }
    public void resetPaddle() {
        // Reinitialize the paddle
        paddle = new Paddle(650, 700, 150, 15);
    }
    public void resetBall(){
        // Reinitialize the ball
        ball = new Ball(725, 600, 7, this);

    }
    public boolean allBricksHit() {
        for (Brick brick : bricks) {
            if (!brick.isAlreadyHit()) {
                return false;
            }
        }
        return true;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(getWidth());
        if (lives > 0) {
            if (!allBricksHit()) {
                paddle.draw(g);
                ball.draw(g);
                for (Brick brick : bricks) {
                    brick.draw(g);
                }
                // Display lives
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Lives: " + lives, 10, 50);
            } else {
                // Display winning screen
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("You Win!", getWidth() / 2 - 100, getHeight() / 2);
            }
        } else {
            // Display losing screen
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", getWidth() / 2 - 100, getHeight() / 2);
        }
    }
}