package mygame;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Paddle {
    private int x, y, width, height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

 //getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x ;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


public void moveLeft() {
        setX(-10);
    }

public void moveRight() {
        setX(10);
    }
}
