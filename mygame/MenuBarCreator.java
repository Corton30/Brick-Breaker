package mygame;

import javax.swing.*;

public class MenuBarCreator {

    public JMenuBar createMenuBar(GamePanel gamePanel) {
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu for levels
        JMenu levelMenu = new JMenu("Levels");

        // Add menu items for each level
        for (int i = 1; i <= gamePanel.getLevelHandler().getMaxLevel(); i++) {
            JMenuItem levelItem = new JMenuItem("Level " + i);
            int level = i;
            levelItem.addActionListener(e -> {
                gamePanel.getLevelHandler().setCurrentLevel(level);
                gamePanel.getLevelHandler().loadLevel();
            });
            levelMenu.add(levelItem);
        }

        // Add the levels menu to the menu bar
        menuBar.add(levelMenu);

        return menuBar;
    }
}