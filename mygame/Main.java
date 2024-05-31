package mygame;

import mygame.GUI.MenuBarCreator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker");
        GamePanel gamePanel = new GamePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 800);
        frame.setResizable(false);
        frame.add(gamePanel);

        // Create an instance of MenuBarCreator
        MenuBarCreator menuBarCreator = new MenuBarCreator();

        // Create the menu bar using the MenuBarCreator instance
        JMenuBar menuBar = menuBarCreator.createMenuBar(gamePanel);

        // Add the menu bar to the frame
        frame.setJMenuBar(menuBar);

        // Make the frame visible after all components are added
        frame.setVisible(true);
    }
}
