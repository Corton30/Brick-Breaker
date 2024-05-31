package mygame;

import java.util.List;

public class LevelHandler {
    private int currentLevel;
    private MapGenerator mapGenerator;
    private int maxLevel = 5;
    private GamePanel gamePanel;

    public LevelHandler(GamePanel gamePanel, MapGenerator mapGenerator) {
        this.gamePanel = gamePanel;
        this.mapGenerator = mapGenerator;
        this.currentLevel = 1;
    }
    public int getMaxLevel() {
        return maxLevel;
    }
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }

    public void nextLevel() {
        currentLevel++;
        List<Brick> bricks = mapGenerator.generateMap(currentLevel);
        gamePanel.setBricks(bricks);
        gamePanel.resetPaddle();
        gamePanel.resetBall();
    }

    public boolean isLastLevel() {
        // Return true if the current level is the last level
        // Adjust this based on the number of levels in your game
        return currentLevel == 5;
    }

    public void loadLevel() {
        List<Brick> bricks = mapGenerator.generateMap(currentLevel);
        gamePanel.setBricks(bricks);
        gamePanel.resetPaddle();
        gamePanel.resetBall();
    }

    public void setCurrentLevel(int level) {
        currentLevel = level;
    }
}