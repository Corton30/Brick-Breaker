package mygame;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y, radius;
    private double xDirection = 0; // velocity in x direction
    private double yDirection = 1; // velocity in y direction
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
    public double getXDirection() {
        return xDirection;
    }
    public double getYDirection() {
        return yDirection;
    }

    public void setY(int y) {
        this.y = y;
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
    }

    public void startMoving() {
        isMoving = true;
    }
    public void reverseYDirection() {
        yDirection = -yDirection;
    }
    public void reverseXDirection() {
        xDirection = -xDirection;
    }
    public void resetBall(){
        // Reinitialize the ball
        this.x = 725;
        this.y = 600;
        this.radius = 8;
        this.isMoving = false;
        this.xDirection = 0;
        this.yDirection = 1;
    }
}