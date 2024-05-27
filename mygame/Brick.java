package mygame;

import java.awt.*;

public class Brick {
    private int x, y, width, height;
    private boolean isHit;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isHit = false;
    }

    public void draw(Graphics g) {
        if (!isHit) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }
    }

    public boolean isHit(Ball ball) {
        if (!isHit && ball.getX() >= x && ball.getX() <= x + width && ball.getY() >= y && ball.getY() <= y + height) {
            isHit = true;
            return true;
        }
        return false;
    }
}