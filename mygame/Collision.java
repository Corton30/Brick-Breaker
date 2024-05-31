package mygame;

import java.util.List;
import java.util.Iterator;
import java.awt.Rectangle;

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
        Rectangle ballBounds = new Rectangle(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), ball.getRadius() * 2, ball.getRadius() * 2);
        Rectangle paddleBounds = new Rectangle(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());

        if(ballBounds.intersects(paddleBounds)){
            // Check if the collision is on the top of the paddle
            if (ball.getY() + ball.getRadius() >= paddle.getY() && ball.getY() + ball.getRadius() <= paddle.getY() + 5) {  // Adjust 5 to a suitable threshold
                ball.setY(paddle.getY() - ball.getRadius() - 1); // Ensure the ball is placed above the paddle

                int paddleSegments = 11; // Number of segments to divide the paddle into
                int segmentWidth = paddle.getWidth() / paddleSegments; // Width of each segment
                int hitSegment = ((ball.getX() -  paddle.getX()) / segmentWidth); // Which segment the ball hit
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
                }
                ball.reverseYDirection(); // Reverse the vertical direction
            } else {
                // Side collision, modify x-direction based on where it hits relative to paddle center
                if (ball.getX() < paddle.getX()) {
                    // Hits the left side
                    ball.setXDirection(-1); // Force direction left
                } else {
                    // Hits the right side
                    ball.setXDirection(1); // Force direction right
                }
            }
        }
    }

    public void checkBallBrickCollision() {
        Ball ball = gamePanel.getBall();
        List<Brick> bricks = gamePanel.getBricks();
        Rectangle ballBounds = new Rectangle(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), 2 * ball.getRadius(), 2 * ball.getRadius());

        for (Brick brick : bricks) {
            Rectangle brickBounds = new Rectangle(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
            if (ballBounds.intersects(brickBounds)) {
                // Calculate centers
                int ballCenterX = ball.getX();
                int ballCenterY = ball.getY();
                int brickCenterX = brick.getX() + brick.getWidth() / 2;
                int brickCenterY = brick.getY() + brick.getHeight() / 2;

                // Determine direction of the collision
                int deltaX = ballCenterX - brickCenterX;
                int deltaY = ballCenterY - brickCenterY;

                if (Math.abs(deltaY) > Math.abs(deltaX)) {
                    ball.reverseYDirection();
                } else {
                    ball.reverseXDirection();
                }

                // Assume brick is destroyed or marked as hit
                brick.setIsHit(true); // Update brick status
                break; // Optional: remove the brick if it should be destroyed on hit
            }
        }
    }




    private void checkBallWallCollision() {
        Ball ball = gamePanel.getBall();
        // Collision with left or right walls
        if (ball.getX() < 0 || ball.getX()  > 1440) {
           ball.reverseXDirection();
        }

        // Collision with top wall
        if (ball.getY() < 0) {
            ball.reverseYDirection();
        }

        // Collision with bottom wall (consider game over or life decrement scenario)
        if (ball.getY() > 780 - ball.getRadius()) {
            ball.reverseYDirection();
            gamePanel.decrementLives();
        }
    }
}