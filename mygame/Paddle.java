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

    //getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x ;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    //Methods
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }
    public void moveLeft() {
        setX(-40);
    }
    public void moveRight() {
        setX(40);
    }
}