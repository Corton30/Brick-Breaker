package mygame.GUI;

import mygame.GamePanel;
import mygame.extra.GameState;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class extends KeyAdapter to handle key events for the game.
 * It contains logic for moving the paddle and the ball, resetting the game, and changing levels.
 */
public class GameKeyAdapter extends KeyAdapter {
    private GamePanel gamePanel;

    /**
     * Constructor for the GameKeyAdapter class.
     * @param gamePanel The GamePanel object that this GameKeyAdapter will interact with.
     */
    public GameKeyAdapter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * This method is called whenever a key is pressed.
     * It contains logic for moving the paddle and the ball, resetting the game, and changing levels.
     * @param e The KeyEvent that triggered this method call.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // If the left or 'A' key is pressed and the paddle is not at the left edge of the screen,
        // move the paddle to the left and start moving the ball.
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            gamePanel.getPaddle().setPaddleMovingLeft(true);
            gamePanel.getBall().startMoving();
        }
        // If the right or 'D' key is pressed and the paddle is not at the right edge of the screen,
        // move the paddle to the right and start moving the ball.
        else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            gamePanel.getPaddle().setPaddleMovingRight(true);
            gamePanel.getBall().startMoving();
        }
        // If the 'R' key is pressed, reset the paddle and the ball.
        else if (key == KeyEvent.VK_R) {
            gamePanel.resetPaddle();
            gamePanel.resetBall();
        }
        // If a number key between 1 and 9 is pressed, change the level to the number pressed,
        // generate a new map for that level, and reset the paddle and the ball.
        if (key >= KeyEvent.VK_1 && key <= KeyEvent.VK_9) {
            int level = key - KeyEvent.VK_0;
            if (level <= gamePanel.getLevelHandler().getMaxLevel() &&
                gamePanel.getGameState() != gamePanel.getGameState().RUNNING) {
                    gamePanel.getLevelHandler().setCurrentLevel(level);
                    gamePanel.getLevelHandler().loadLevel();
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot change levels while the game is running!\n" +
                                    "Please press (P) to pause and then change levels",
                            "Game Running", JOptionPane.ERROR_MESSAGE);
                }
        }
        // If the 'Enter' key is pressed, reset the game
        else if (key == KeyEvent.VK_ENTER) {
            if (gamePanel.getGameState() == GameState.GAME_OVER || gamePanel.getGameState() == GameState.GAME_WON) {
                gamePanel.resetGame();
                gamePanel.setGameState(GameState.RUNNING);
            }
        }
        // If the 'P' key is pressed, toggle the game state between RUNNING and PAUSED.
        else if (key == KeyEvent.VK_P) {
            if (gamePanel.getGameState() == GameState.RUNNING) {
                gamePanel.setGameState(GameState.PAUSED);
            } else if (gamePanel.getGameState() == GameState.PAUSED) {
                gamePanel.setGameState(GameState.RUNNING);
            }
        }
        else if (key == KeyEvent.VK_S) {
                gamePanel.getBall().increaseSpeed(2);
        }
        // Repaint the game panel to reflect the changes made by the key press.
        gamePanel.repaint();
    }

    /**
     * This method is called whenever a key is released.
     * It contains logic for stopping the paddle when the left or right key is released.
     * @param e The KeyEvent that triggered this method call.
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // If the left or 'A' key is released, stop moving the paddle to the left.
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            gamePanel.getPaddle().setPaddleMovingLeft(false);
        }
        // If the right or 'D' key is released, stop moving the paddle to the right.
        else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            gamePanel.getPaddle().setPaddleMovingRight(false);
        }
    }
}