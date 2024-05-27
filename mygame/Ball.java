package mygame;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y, radius;
    private int xDirection = 0; // velocity in x direction
    private int yDirection = 2; // velocity in y direction

    private Random random = new Random();
    private boolean isMoving = false;


    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
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


        // Get the width of the game window
        Frame frame = (Frame) Frame.getFrames()[0];
        int windowWidth = frame.getWidth();

        // Check for collision with left or right wall
        if (x - radius <= 0 || x + radius >= windowWidth ) {
            xDirection = -xDirection;
        }

        // Check for collision with top wall
        if (y <= 0) {
            yDirection = -yDirection;
        }
    }


    public void startMoving() {
        isMoving = true;
    }
    public void reverseDirection() {
        yDirection = -yDirection;

        xDirection = random.nextInt(5) - 2;
    }

}