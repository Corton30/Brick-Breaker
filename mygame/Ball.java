package mygame;

import java.awt.*;

public class Ball {
    private int x, y, radius;
    private int xDirection = 0; // velocity in x direction
    private int yDirection = 2; // velocity in y direction

    private boolean isMoving = false;

    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

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
        xDirection = -xDirection;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}