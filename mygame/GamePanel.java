package mygame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel {
    private Paddle paddle;

    public GamePanel() {
        paddle = new Paddle(350, 500, 100, 10);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A) {
                    paddle.moveLeft();
                    repaint();
                } else if (key == KeyEvent.VK_D) {
                    paddle.moveRight();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
    }
}