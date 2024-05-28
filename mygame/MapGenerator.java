package mygame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGenerator {
    private Random random = new Random();

    public List<Brick> generateMap(int level) {
        List<Brick> bricks = new ArrayList<>();
        switch (level) {
            case 1:
                bricks.add(new Brick(100, 200, 1200, 20));
                break;
            case 2:
                for (int i = 1; i < 14; i++) {
                    for (int j = 2; j < 8; j++) {
                        bricks.add(new Brick(i * 100, j * 50, 80, 30));
                    }
                }
                break;

            case 3: // Letter "A"
                for (int i = 3; i < 11; i++) {
                    bricks.add(new Brick(i * 100, 200, 80, 30)); // Top part of "A"
                    bricks.add(new Brick(i * 100, 500, 80, 30)); // Middle part of "A"
                }
                for (int j = 3; j < 8; j++) {
                    bricks.add(new Brick(300, j * 50, 80, 30)); // Left leg of "A"
                    bricks.add(new Brick(1000, j * 50, 80, 30)); // Right leg of "A"
                }
                break;

            case 4: // Random bricks
                for (int i = 0; i < 50; i++) {
                    int x = random.nextInt(14) * 100;
                    int y = random.nextInt(6) * 50 + 200;
                    bricks.add(new Brick(x, y, 80, 30));
                }
                break;

            case 5: // Spiral pattern
            int centerX = 720; // Center of the screen
            int centerY = 450;
            int brickWidth = 80;
            int brickHeight = 30;
            int spiralSize = 1; // The size of the spiral (number of bricks on one side)

            // Start with a single brick in the center
            bricks.add(new Brick(centerX, centerY, brickWidth, brickHeight));

            while (spiralSize < 7) { // Adjust this number to change the size of the spiral
                // Top side
                for (int i = 0; i < spiralSize; i++) {
                    bricks.add(new Brick(centerX + i * brickWidth, centerY - spiralSize * brickHeight, brickWidth, brickHeight));
                }
                // Right side
                for (int i = 0; i < spiralSize; i++) {
                    bricks.add(new Brick(centerX + spiralSize * brickWidth, centerY + i * brickHeight, brickWidth, brickHeight));
                }
                // Bottom side
                for (int i = 0; i < spiralSize; i++) {
                    bricks.add(new Brick(centerX - i * brickWidth, centerY + spiralSize * brickHeight, brickWidth, brickHeight));
                }
                // Left side
                for (int i = 0; i < spiralSize; i++) {
                    bricks.add(new Brick(centerX - spiralSize * brickWidth, centerY - i * brickHeight, brickWidth, brickHeight));
                }

                spiralSize++;
            }
            break;
        }
        return bricks;
    }
}