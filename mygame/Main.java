package mygame;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker");
        GamePanel gamePanel = new GamePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 900);
        frame.setVisible(true);
        frame.setResizable(false);

        frame.add(gamePanel);

    }
}
