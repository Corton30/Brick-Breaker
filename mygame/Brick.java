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
        if (!isHit &&
                ball.getX() + ball.getRadius() >= x &&
                ball.getX() - ball.getRadius() <= x + width &&
                ball.getY() + ball.getRadius() >= y &&
                ball.getY() - ball.getRadius() <= y + height){
            isHit = true;
            return true;
        }
        return false;

    }

    public boolean isAlreadyHit() {
        return isHit;
    }

}