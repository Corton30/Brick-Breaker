package mygame.props;

import mygame.GamePanel;

import java.awt.*;


public class Ball {
    private int x, y, radius;

    private double xDirection = 0; // velocity in x direction
    private double yDirection = 1; // velocity in y direction

    private boolean isMoving = false;
    private GamePanel gamePanel;
    private Color color;

    public Ball(int x, int y, int radius, GamePanel gamePanel, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.gamePanel = gamePanel;
        this.color = color;
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
        g.setColor(this.color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
    public void update() {
        if (isMoving) {
            x += (int) xDirection;
            y += (int) yDirection;
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
    public void increaseSpeed(double factor) {
        this.xDirection *= factor;
        this.yDirection *= factor;
    }
}