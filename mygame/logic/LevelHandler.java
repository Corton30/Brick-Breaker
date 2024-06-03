package mygame.logic;

import mygame.GamePanel;
import mygame.Maps.MapGenerator;
import mygame.extra.GameState;
import mygame.props.Brick;

import java.util.List;

public class LevelHandler {
    private int currentLevel;
    private MapGenerator mapGenerator;
    private int maxLevel = 9;
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
        return currentLevel == maxLevel;
    }

    public void loadLevel() {
        List<Brick> bricks = mapGenerator.generateMap(currentLevel);
        gamePanel.setBricks(bricks);
        gamePanel.resetPaddle();
        gamePanel.resetBall();
        gamePanel.setGameState(GameState.RUNNING);
    }

    public void setCurrentLevel(int level) {
        currentLevel = level;
    }
}