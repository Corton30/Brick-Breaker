package mygame;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Brick extends Rectanglee {

    private boolean isHit;


    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.isHit = false;
    }

    public void draw(Graphics g) {
        if (!isHit) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }
    }

    public boolean isHit(Ball ball) {
        Rectangle2D ballRect = new Rectangle2D.Double(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), 2 * ball.getRadius(), 2 * ball.getRadius());
        Rectangle2D brickRect = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
        if (!isHit && ballRect.intersects(brickRect)) {
            isHit = true;
            return true;
        }
        return false;
    }
    public boolean isAlreadyHit() {
        return isHit;
    }

}