package mygame.GUI;

import mygame.GamePanel;
import mygame.extra.GameState;

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
                if (gamePanel.getGameState() != gamePanel.getGameState().RUNNING) {
                    gamePanel.getLevelHandler().setCurrentLevel(level);
                    gamePanel.getLevelHandler().loadLevel();
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot change levels while the game is running!\n" +
                                    "Please press (P) to pause and then change levels",
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
             gamePanel.toggleSound();
        });
        // Add the mute item to the settings menu
        settingsMenu.add(muteItem);


        // Create a menu item for increasing ball speed
        JMenuItem increaseSpeedItem = new JMenuItem("Increase Ball Speed");
        increaseSpeedItem.addActionListener(e -> {
            if(gamePanel.getGameState() != GameState.RUNNING) {
                gamePanel.getBall().increaseSpeed(2);
            }
            else {
                JOptionPane.showMessageDialog(null, "Cannot change speed while the game is running!\n" +
                                "Please press (P) to pause and then change speed",
                        "Game Running", JOptionPane.ERROR_MESSAGE);
            }
        });
        // Add the increase ball speed item to the settings menu
        settingsMenu.add(increaseSpeedItem);

        // Add the levels menu to the menu bar
        menuBar.add(levelMenu);
        // Add the Settings menu to the menu bar
        menuBar.add(settingsMenu);


        return menuBar;
    }
}


