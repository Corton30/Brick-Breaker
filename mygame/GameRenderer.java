// GameRenderer.java
package mygame;

import java.awt.*;

public class GameRenderer {
    private GamePanel gamePanel;

    public GameRenderer(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void render(Graphics g) {
        gamePanel.getPaddle().draw(g);
        gamePanel.getBall().draw(g);
        for (Brick brick : gamePanel.getBricks()) {
            brick.draw(g);
        }

        if (gamePanel.getLives() > 0) {
            if (!gamePanel.allBricksHit()) {
                gamePanel.getPaddle().draw(g);
                gamePanel.getBall().draw(g);
                for (Brick brick : gamePanel.getBricks()) {
                    brick.draw(g);
                }
                // Display lives
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Lives: " + gamePanel.getLives(), 10, 50);
            } else {
                gamePanel.getPaddle().draw(g);
                gamePanel.getBall().draw(g);
                for (Brick brick : gamePanel.getBricks()) {
                    brick.draw(g);
                }
                // Display winning screen
                g.setColor(Color.RED);
                g.setFont(new Font("serif",Font.BOLD, 30));
                g.drawString("You Won", gamePanel.getWidth() / 2 - 100, gamePanel.getHeight() / 2);
                // Display restart
                g.setColor(Color.RED);
                g.setFont(new Font("serif",Font.BOLD, 20));
                g.drawString("Press (Enter) to Restart", (gamePanel.getWidth() / 2 - 100)-30, (gamePanel.getHeight() / 2)+50);
            }
        } else {
            // Display losing screen
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", gamePanel.getWidth() / 2 - 100, gamePanel.getHeight() / 2);
            // Display restart
            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", (gamePanel.getWidth() / 2 - 100)+40, (gamePanel.getHeight() / 2)+50);
        }
    }
}