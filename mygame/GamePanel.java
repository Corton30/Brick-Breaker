package mygame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Collision collision;


    public Paddle getPaddle() {
        return paddle;
    }
    public Ball getBall() {
        return ball;
    }
    public void resetBall() {
        ball.resetBall();
    }
    public void resetPaddle() {
        paddle.resetPaddle();
    }
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }
    public MapGenerator getMapGenerator() {
        return mapGenerator;
    }
    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
    public  List<Brick> getBricks() {
        return bricks;
    }

    public GamePanel() {
        // Initialize the paddle
        this.paddle = new Paddle(650, 700, 150, 15);
        // Initialize the ball
        this.ball = new Ball(725, 600, 7, this);
        // Initialize the map generator
        mapGenerator = new MapGenerator();
        // Start with level 1
        currentLevel = 1;
        bricks = mapGenerator.generateMap(currentLevel);
        setFocusable(true);
        // Initialize the collision detector
        collision = new Collision(this);

        // Create a new instance of GameKeyAdapter and add it as a key listener
        GameKeyAdapter gameKeyAdapter = new GameKeyAdapter(this);
        addKeyListener(gameKeyAdapter);

        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.update();
                collision.checkCollisions();

                repaint();
            }
        });
        timer.start();
    }

    public void decrementLives() {
        lives--;
        paddle.resetPaddle();
        ball.resetBall();
    }

    public void resetGame() {
        // Reset the paddle and the ball
        resetPaddle();
        resetBall();

        // Reset the lives
        lives = 3;

        // Regenerate the bricks for the current level
        bricks = mapGenerator.generateMap(currentLevel);
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
                paddle.draw(g);
                ball.draw(g);
                for (Brick brick : bricks) {
                    brick.draw(g);
                }
                // Display winning screen
                g.setColor(Color.RED);
                g.setFont(new Font("serif",Font.BOLD, 30));
                g.drawString("You Won", getWidth() / 2 - 100, getHeight() / 2);
                // Display restart
                g.setColor(Color.RED);
                g.setFont(new Font("serif",Font.BOLD, 20));
                g.drawString("Press (Enter) to Restart", (getWidth() / 2 - 100)-30, (getHeight() / 2)+50);
            }
        } else {

            // Display losing screen
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", getWidth() / 2 - 100, getHeight() / 2);
            // Display restart
            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", (getWidth() / 2 - 100)+40, (getHeight() / 2)+50);
        }
    }
}