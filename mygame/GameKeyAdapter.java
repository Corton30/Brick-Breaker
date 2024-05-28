package mygame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyAdapter extends KeyAdapter {
    private GamePanel gamePanel;

    public GameKeyAdapter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) && gamePanel.getPaddle().getX() > 0) {
            gamePanel.getPaddle().moveLeft();
            gamePanel.getBall().startMoving();
        } else if ((key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) && gamePanel.getPaddle().getX() + gamePanel.getPaddle().getWidth() <= 1440) {
            gamePanel.getPaddle().moveRight();
            gamePanel.getBall().startMoving();
        } else if (key == KeyEvent.VK_R) {
            gamePanel.resetPaddle();
            gamePanel.resetBall();
        } else if (key >= KeyEvent.VK_1 && key <= KeyEvent.VK_5) {
            gamePanel.setCurrentLevel(key - KeyEvent.VK_0);
            gamePanel.setBricks(gamePanel.getMapGenerator().generateMap(gamePanel.getCurrentLevel()));
            gamePanel.resetPaddle();
            gamePanel.resetBall();
        }
        gamePanel.repaint();
    }
}