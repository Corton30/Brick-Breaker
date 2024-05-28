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
            int paddleSegments = 5; // Number of segments to divide the paddle into
            int segmentWidth = width / paddleSegments; // Width of each segment
            int hitSegment = (ball.getX() - x) / segmentWidth; // Which segment the ball hit

            switch (hitSegment) {
                case 0: // Far left
                    ball.setXDirection(-2);
                    break;
                case 1: // Left
                    ball.setXDirection(-1);
                    break;
                case 2: // Middle
                    ball.setXDirection(0);
                    break;
                case 3: // Right
                    ball.setXDirection(1);
                    break;
                case 4: // Far right
                    ball.setXDirection(2);
                    break;
            }
            ball.reverseDirection();
        }
    }

    public void moveRight() {
        this.x  += speed;
    }

    public void resetPaddle() {
        // Reinitialize the paddle
        this.setRect(650, 700, 150, 15);
    }
}