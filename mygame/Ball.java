package mygame;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y, radius;
    private int xDirection = 0; // velocity in x direction
    private int yDirection = 2; // velocity in y direction
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
        checkWallCollisions();
    }



    private void checkWallCollisions() {
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
            gamePanel.decrementLives(); // Assuming you have a method to decrement lives
        }
    }
    public void startMoving() {
        isMoving = true;
    }
    public void reverseDirection() {
        yDirection = -yDirection;
        xDirection = random.nextInt(2) == 0 ? -1 : 1;
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