package mygame;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Paddle extends Rectanglee {

    private static final int PADDLE_SPEED = 5;
    private boolean isPaddleMovingLeft = false;
    private boolean isPaddleMovingRight = false;
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

    public void setPaddleMovingLeft(boolean isMoving) {
        this.isPaddleMovingLeft = isMoving;
    }
    public void setPaddleMovingRight(boolean isMoving) {
        this.isPaddleMovingRight = isMoving;
    }

    public void update() {
        if (isPaddleMovingLeft && this.getX() > 0) {
            this.moveLeft();
        }
        if (isPaddleMovingRight && this.getX() + this.getWidth() <= 1440) {
            this.moveRight();
        }
    }

    public void resetPaddle() {
        // Reinitialize the paddle
        this.setX(650);
        this.setY(700);
        this.setWidth(154);
        this.setHeight(15);
    }
}