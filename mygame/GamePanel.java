package mygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private Paddle paddle;
    private Ball ball;
    private List<Brick> bricks;

    public GamePanel() {
        // Initialize the paddle
        paddle = new Paddle(650, 700, 150, 15);
        // Initialize the ball
        ball = new Ball(725, 600, 7);
        // Initialize the bricks
        bricks = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            for (int j = 2; j < 8; j++) {
                bricks.add(new Brick(i * 100, j * 50, 80, 30));
            }
        }

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    paddle.moveLeft();
                    ball.startMoving();
                } else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    paddle.moveRight();
                    ball.startMoving();
                }


                repaint();
            }
        });
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.update();
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }
}