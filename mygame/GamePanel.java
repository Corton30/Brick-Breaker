package mygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Color;

public class GamePanel extends JPanel {
    private Paddle paddle;
    private Ball ball;

    public GamePanel() {
        paddle = new Paddle(650, 700, 150, 15);
        ball = new Ball(725, 600, 7);


        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    paddle.moveLeft();
                } else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    paddle.moveRight();
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
    }
}