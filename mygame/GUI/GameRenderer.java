// GameRenderer.java
package mygame.GUI;

import mygame.GamePanel;
import mygame.extra.GameState;
import mygame.props.Brick;

import java.awt.*;

/**
 * This class is responsible for rendering the game objects and the game state on the screen.
 * It uses the Java AWT (Abstract Window Toolkit) for drawing.
 */
public class GameRenderer {
    private GamePanel gamePanel;

    /**
     * Constructs a new GameRenderer object.
     *
     * @param gamePanel The game panel that this renderer will draw on.
     */
    public GameRenderer(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * Renders the game objects and the game state on the screen.
     *
     * @param g The Graphics object to protect.
     */
    public void render(Graphics g) {
        // Draw mouse coordinates
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Mouse X: " + gamePanel.getMouseX() + ", Mouse Y: " + gamePanel.getMouseY(), 10, 15);

        // Check the game state
        if (gamePanel.getGameState() == GameState.PAUSED) {
            // Display paused screen
            g.setColor(Color.BLACK);
            g.setFont(new Font("serif", Font.BOLD, 60));
            g.drawString("Game Paused...", 540, 320);
        } else if (gamePanel.getGameState() != GameState.GAME_OVER) {
            // Draw game objects
            drawGameObjects(g);
            if (!gamePanel.allBricksHit()) {
                // Display lives
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Lives: " + gamePanel.getLives(), 10, 50);
            } else {
                // Display winning screen
                g.setColor(Color.RED);
                g.setFont(new Font("serif",Font.BOLD, 40));
                g.drawString("You Won", 645, 320);
                // Display restart
                g.setColor(Color.BLACK);
                g.setFont(new Font("serif",Font.BOLD, 20));
                g.drawString("Press (Enter) to go to the Next level", 645-60, 320+50);
                // Set GameState to GAME_WON
                gamePanel.setGameState(GameState.GAME_WON);
            }
        } else if (gamePanel.getGameState() == GameState.GAME_OVER) {
            // Display losing screen
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", 610, 325);
            // Display restart
            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 610+35, 325+50);
        }
    }

    /**
     * Draws the game objects (paddle, ball, bricks) on the screen.
     *
     * @param g The Graphics object to protect.
     */
    private void drawGameObjects(Graphics g) {
        gamePanel.getPaddle().draw(g);
        gamePanel.getBall().draw(g);
        for (Brick brick : gamePanel.getBricks()) {
            brick.draw(g);
        }
    }
}