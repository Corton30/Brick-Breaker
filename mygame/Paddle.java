package mygame;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Paddle extends Rectangle {

    private int speed = 40;
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
        this.x  -= speed;

    }
    // Check for collision with paddle
    public void BallHit(Ball ball) {
        if(     ball.getX() + ball.getRadius() >= x &&
                ball.getX() - ball.getRadius() <= x + width &&
                ball.getY() + ball.getRadius() >= y &&
                ball.getY() - ball.getRadius() <= y + height){
            ball.reverseDirection();
        }
    }

    public void moveRight() {
        this.x  += speed;
    }
}