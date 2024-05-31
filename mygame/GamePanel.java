package mygame;

import mygame.GUI.GameKeyAdapter;
import mygame.GUI.GameRenderer;
import mygame.Maps.MapGenerator;
import mygame.extra.GameState;
import mygame.logic.Collision;
import mygame.logic.LevelHandler;
import mygame.props.Ball;
import mygame.props.Brick;
import mygame.props.Paddle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GamePanel extends JPanel {

    private GameState gameState = GameState.RUNNING;

    private static final int INITIAL_LIVES = 3;
    private Paddle paddle;
    private Ball ball;
    private int currentLevel=1;
    private List<Brick> bricks;
    private int lives = INITIAL_LIVES;
    private Collision collision;
    private MapGenerator mapGenerator;
    private GameRenderer gameRenderer;
    private int mouseX = 0;
    private int mouseY = 0;
    private LevelHandler levelHandler;



    public Paddle getPaddle() {
        return paddle;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public Ball getBall() {
        return ball;
    }
    public int getLives() {
        return lives;
    }
    public void resetBall() {
        ball.resetBall();
    }
    public void resetPaddle() {
        paddle.resetPaddle();
    }
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }
    public MapGenerator getMapGenerator() {
        return mapGenerator;
    }
    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
    public  List<Brick> getBricks() {
        return bricks;
    }
    public int getMouseX() {
        return mouseX;
    }
    public int getMouseY() {
        return mouseY;
    }

    public GamePanel() {
        // Initialize the paddle
        this.paddle = new Paddle(650, 700, 154, 15);
        // Initialize the ball
        this.ball = new Ball(725, 600, 8, this);
        // Initialize the map generator
        mapGenerator = new MapGenerator();
        // Generate the bricks for the current level
        bricks = mapGenerator.generateMap(currentLevel);
        setFocusable(true);
        // Initialize the collision detector
        collision = new Collision(this);
        // Initialize the game renderer
        gameRenderer = new GameRenderer(this);
        // Initialize the level handler
        levelHandler = new LevelHandler(this, mapGenerator);
        // Create a new instance of GameKeyAdapter and add it as a key listener
        GameKeyAdapter gameKeyAdapter = new GameKeyAdapter(this);
        addKeyListener(gameKeyAdapter);
        // Create a new timer that will update the game every 5 milliseconds
        Timer timer = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameState == GameState.RUNNING) {
                    collision.checkCollisions();
                    ball.update();
                    paddle.update();
                }
                repaint();
            }
        });
        timer.start();

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
}

    public void decrementLives() {
        lives--;
        if (lives == 0) {
            gameState = GameState.GAME_OVER;
        } else {
            paddle.resetPaddle();
            ball.resetBall();
        }
    }
    public void resetGame() {
        // Reset the paddle and the ball
        resetPaddle();
        resetBall();
        // Reset the lives
        lives = INITIAL_LIVES;
        // Regenerate the bricks for the current level
        bricks = mapGenerator.generateMap(currentLevel);
        // If the game was won, and it's not the last level, go to the next level
        if (gameState == GameState.GAME_WON && !levelHandler.isLastLevel()) {
            levelHandler.nextLevel();
        } else {
            // Otherwise, reset to the first level
            levelHandler = new LevelHandler(this, mapGenerator);
        }
    }
    public boolean allBricksHit() {
        for (Brick brick : bricks) {
            if (!brick.isAlreadyHit()) {
                return false;
            }
        }
        return true;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameRenderer.render(g);

    }

    public LevelHandler getLevelHandler() {
        return levelHandler;
    }
}