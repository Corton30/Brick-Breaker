package mygame.GUI;

import mygame.GamePanel;

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
                if (gamePanel.getGameState() == gamePanel.getGameState().GAME_WON ||
                    gamePanel.getGameState() == gamePanel.getGameState().GAME_OVER ||
                        gamePanel.getGameState() == gamePanel.getGameState().PAUSED) {

                    gamePanel.getLevelHandler().setCurrentLevel(level);
                    gamePanel.getLevelHandler().loadLevel();
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot change levels while the game is running!",
                            "Game Running", JOptionPane.ERROR_MESSAGE);
                }

            });
            levelMenu.add(levelItem);
        }

        // Create a menu for settings
        JMenu settingsMenu = new JMenu("Settings");
        // Create a checkbox menu item for mute sound
        JCheckBoxMenuItem muteItem = new JCheckBoxMenuItem("  Mute Sound");
        muteItem.addActionListener(e -> {
            // Toggle sound here
            // You might need to add a method in your gamePanel or sound effect class to mute/unmute the sound
             gamePanel.toggleSound();
        });

        // Add the mute item to the settings menu
        settingsMenu.add(muteItem);





        // Add the levels menu to the menu bar
        menuBar.add(levelMenu);
        menuBar.add(settingsMenu);

        return menuBar;
    }
}


