package mygame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
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

//                ball.update();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
    }
}