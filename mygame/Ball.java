package mygame;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y, radius;
    private double xDirection = 0; // velocity in x direction
    private double yDirection = 2; // velocity in y direction
    private Random random = new Random();
    private boolean isMoving = false;
    private GamePanel gamePanel;

    public Ball(int x, int y, int radius, GamePanel gamePanel) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.gamePanel = gamePanel;
    }
    //getters and setters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getRadius() {
        return radius;
    }
    public void setXDirection(double xDirection) {
        this.xDirection = xDirection;
    }


    //Methods
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
    public void update() {
        if (isMoving) {
            x += xDirection;
            y += yDirection;
        }
        checkCollisions();
    }

    private void checkCollisions() {
        // Collision with left or right walls
        if (x - radius <= 0 || x + radius >= 1440) {
            xDirection = -xDirection;
        }

        // Collision with top wall
        if (y - radius <= 0) {
            yDirection = -yDirection;
        }

        // Collision with bottom wall (consider game over or life decrement scenario)
        if (y + radius >= 900 - radius) {
            yDirection = -yDirection;
            gamePanel.decrementLives();
        }

        // Check for collision with paddle
        gamePanel.getPaddle().BallHit(gamePanel.getBall());

        // Check for collision with bricks
        for (Brick brick : gamePanel.getBricks()) {
            if (brick.isHit(gamePanel.getBall())) {
                gamePanel.getBall().reverseDirection();
            }
        }
    }
    public void startMoving() {
        isMoving = true;
    }
    public void reverseDirection() {
        yDirection = -yDirection;
//        xDirection = random.nextInt(2) == 0 ? -1 : 1;
    }
    public void resetBall(){
        // Reinitialize the ball
        this.x = 725;
        this.y = 600;
        this.radius = 7;
        this.isMoving = false;
        this.xDirection = 0;
        this.yDirection = 2;
    }
}