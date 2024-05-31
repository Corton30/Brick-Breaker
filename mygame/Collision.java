package mygame;

import java.util.List;
import java.util.Iterator;

public class Collision {
    private GamePanel gamePanel;

    public Collision(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkCollisions() {
        checkBallPaddleCollision();
        checkBallBrickCollision();
        checkBallWallCollision();
    }

    private void checkBallPaddleCollision() {
        Paddle paddle = gamePanel.getPaddle();
        Ball ball = gamePanel.getBall();
        if(     ball.getX() + ball.getRadius() >= paddle.getX() &&
                ball.getX() - ball.getRadius() <= paddle.getX() + paddle.getWidth() &&
                ball.getY() + ball.getRadius() >= paddle.getY() &&
                ball.getY() - ball.getRadius() <= paddle.getY() + paddle.getHeight()){
            int paddleSegments = 11; // Number of segments to divide the paddle into
            int segmentWidth = paddle.getWidth() / paddleSegments; // Width of each segment
            int hitSegment = (int) ((ball.getX() -  paddle.getX()) / segmentWidth); // Which segment the ball hit

            switch (hitSegment) {
                case 0: // Far left
                    ball.setXDirection(-3);
                    break;
                case 1: // Far left
                    ball.setXDirection(-2.5);
                    break;
                case 2: // left
                    ball.setXDirection(-1);
                    break;
                case 3: // Left
                    ball.setXDirection(-1.5);
                    break;
                case 4: // left
                    ball.setXDirection(-1);
                    break;
//                case 5: // Middle
//                    ball.setXDirection(0);
//                    break;
                case 6: // right
                    ball.setXDirection(1);
                    break;
                case 7: // right
                    ball.setXDirection(1.5);
                    break;
                case 8: // right
                    ball.setXDirection(2);
                    break;
                case 9: // Far right
                    ball.setXDirection(2.5);
                    break;
                case 10: // Far right
                    ball.setXDirection(3);
                    break;

                default:


            }
            ball.reverseYDirection();
        }
    }

    private void checkBallBrickCollision() {
        Ball ball = gamePanel.getBall();
        List<Brick> bricks = gamePanel.getBricks();
        for (Iterator<Brick> iterator = bricks.iterator(); iterator.hasNext();) {
            Brick brick = iterator.next();
            if (!brick.isAlreadyHit() && brick.isHit(ball)) {
                ball.reverseYDirection();
                iterator.remove();
            }
        }
    }

    private void checkBallWallCollision() {
        Ball ball = gamePanel.getBall();
        // Collision with left or right walls
        if (ball.getX() - ball.getRadius() <= 0 || ball.getX() + ball.getRadius() >= 1440) {
            ball.reverseXDirection();
        }

        // Collision with top wall
        if (ball.getY() - ball.getRadius() <= 0) {
            ball.reverseYDirection();
        }

        // Collision with bottom wall (consider game over or life decrement scenario)
        if (ball.getY() + ball.getRadius() >= 900 - ball.getRadius()) {
            ball.reverseYDirection();
            gamePanel.decrementLives();
        }
    }
}