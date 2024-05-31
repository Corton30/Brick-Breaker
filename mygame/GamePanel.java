package mygame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;



public class GamePanel extends JPanel {

    private static final int INITIAL_LIVES = 3;
    private Paddle paddle;
    private Ball ball;

    private int currentLevel=1;
    private List<Brick> bricks;
    private int lives = INITIAL_LIVES;
    private Collision collision;
    private MapGenerator mapGenerator;
    private GameRenderer gameRenderer;


    public Paddle getPaddle() {
        return paddle;
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

    public GamePanel() {
        // Initialize the paddle
        this.paddle = new Paddle(650, 700, 154, 15);
        // Initialize the ball
        this.ball = new Ball(725, 600, 7, this);
        // Initialize the map generator
        mapGenerator = new MapGenerator();
        // Generate the bricks for the current level
        bricks = mapGenerator.generateMap(currentLevel);
        setFocusable(true);
        // Initialize the collision detector
        collision = new Collision(this);
        // Initialize the game renderer
        gameRenderer = new GameRenderer(this);
        // Create a new instance of GameKeyAdapter and add it as a key listener
        GameKeyAdapter gameKeyAdapter = new GameKeyAdapter(this);
        addKeyListener(gameKeyAdapter);
        // Create a new timer that will update the game every 5 milliseconds
        Timer timer = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ball.update();
                collision.checkCollisions();
                paddle.update();
                repaint();
            }
        });
        timer.start();
    }

    public void decrementLives() {
        lives--;
        paddle.resetPaddle();
        ball.resetBall();
    }
    public void resetGame() {
        // Reset the paddle and the ball
        resetPaddle();
        resetBall();

        // Reset the lives
        lives = INITIAL_LIVES;

        // Regenerate the bricks for the current level
        bricks = mapGenerator.generateMap(currentLevel);
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
}