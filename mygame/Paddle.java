package mygame;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Paddle extends Rectangle {

    private static final int PADDLE_SPEED = 40;
    public Paddle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    //getters and setters

    //Methods
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

    public void moveLeft() {
        this.x  -= PADDLE_SPEED;

    }

    public void moveRight() {
        this.x  += PADDLE_SPEED;
    }

    public void resetPaddle() {
        // Reinitialize the paddle
        this.setRect(650, 700, 150, 15);
    }
}