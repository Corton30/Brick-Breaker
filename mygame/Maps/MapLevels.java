package mygame.Maps;

import mygame.props.Brick;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import java.util.Random;

public class MapLevels {
    private Random random = new Random();
    List<Brick> bricks = new ArrayList<>();


    public List<Brick> levelOne() {
        List<Brick> bricks = new ArrayList<>();
        Color brickColor = Color.RED;
        bricks.add(new Brick(100, 200, 1200, 20,brickColor));
        return bricks;
    }
    public List<Brick> levelTwo() {
        List<Brick> bricks = new ArrayList<>();

        for (int i = 1; i < 14; i++) {
            for (int j = 2; j < 8; j++) {


// Generate random values for red, green, and blue color components
                int red = random.nextInt(5, 80); // Low values to minimize red influence
                int green = random.nextInt(50, 100); // Low values to minimize green influence
                int blue = random.nextInt(180, 255); // High values to ensure it remains dominantly blue

// Create a new color with the random components
                Color brickColor = new Color(red, green, blue);


                bricks.add(new Brick(i * 100, j * 50, 80, 30,brickColor));
            }
        }
        return bricks;
    }
    public List<Brick> levelThree() {
        List<Brick> bricks = new ArrayList<>();
        Color brickColor = Color.ORANGE;

        for (int i = 3; i < 11; i++) {
            bricks.add(new Brick(i * 100, 200, 80, 30,brickColor)); // Top part of "A"
            bricks.add(new Brick(i * 100, 500, 80, 30,brickColor)); // Middle part of "A"
        }
        brickColor = Color.BLACK;
        for (int j = 3; j < 8; j++) {
            bricks.add(new Brick(300, j * 50, 80, 30,brickColor)); // Left leg of "A"
            bricks.add(new Brick(1000, j * 50, 80, 30,brickColor)); // Right leg of "A"
        }
        return bricks;
    }
    public List<Brick> levelFour() {
        List<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(13) * 100 + 70;
            int y = random.nextInt(7) * 50 + 100;


            // Generate random values for red, green, and blue color components
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            // Create a new color with the random components
            Color brickColor = new Color(red, green, blue);

            bricks.add(new Brick(x, y, 80, 30, brickColor));
        }
        return bricks;
    }
    public List<Brick> levelFive() {
        List<Brick> bricks = new ArrayList<>();
        Color brickColor = Color.GRAY;

        int centerX = 700; // Center of the screen
        int centerY = 250;
        int brickWidth = 80;
        int brickHeight = 30;
        int spiralSize = 1; // The size of the spiral (number of bricks on one side)

        // Start with a single brick in the center
        bricks.add(new Brick(centerX, centerY, brickWidth, brickHeight, brickColor));

        while (spiralSize < 7) { // Adjust this number to change the size of the spiral
            // Top side
            for (int i = 0; i < spiralSize; i++) {
                bricks.add(new Brick(centerX + i * brickWidth, centerY - spiralSize * brickHeight, brickWidth, brickHeight, brickColor));
            }
            // Right side
            for (int i = 0; i < spiralSize; i++) {
                bricks.add(new Brick(centerX + spiralSize * brickWidth, centerY + i * brickHeight, brickWidth, brickHeight, brickColor));
            }
            // Bottom side
            for (int i = 0; i < spiralSize; i++) {
                bricks.add(new Brick(centerX - i * brickWidth, centerY + spiralSize * brickHeight, brickWidth, brickHeight, brickColor));
            }
            // Left side
            for (int i = 0; i < spiralSize; i++) {
                bricks.add(new Brick(centerX - spiralSize * brickWidth, centerY - i * brickHeight, brickWidth, brickHeight, brickColor));
            }

            spiralSize++;
        }
        return bricks;
    }
    public List<Brick> levelSix() {
        List<Brick> bricks = new ArrayList<>();
        Color brickColor = Color.RED;
        int brickSize = 60; // Square bricks
        int startX = 90; // Starting x-offset closer to the left side of the screen
        int startY = 100; // Starting y-offset, kept same as your previous setup

        // Setup for 7 rows and more columns extending horizontally
        for (int j = 0; j < 6; j++) { // Limit to 7 rows
            for (int i = 0; i < 21; i++) { // Increased the number of columns to expand width
                if ((i + j) % 2 == 0) { // Maintain the checkered pattern
                    bricks.add(new Brick(i * brickSize + startX, j * brickSize + startY, brickSize, brickSize,brickColor));
                }
            }
        }
        return bricks;
    }
    public List<Brick> levelSeven() {
        List<Brick> bricks = new ArrayList<>();
        Color brickColor = Color.RED;
        int brickWidth = 60;
        int brickHeight = 20;
        int centerX = 700;
        int centerY = 250;
        int radius = 200;
        for (int i = 0; i < 360; i += 15) {
            double angle = Math.toRadians(i);
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));
            bricks.add(new Brick(x, y, brickWidth, brickHeight, brickColor));
        }
        return bricks;
    }
    public List<Brick> levelEight() {
            List<Brick> bricks = new ArrayList<>();
        Color brickColor = Color.RED;

        int brickSize = 60; // Square bricks
            int startX = 430; // Starting x-offset closer to the left side of the screen
            int startY = 50; // Starting y-offset, kept same as your previous setup

            // Heart shape pattern
            int[][] heartShape = {
                    {0,0,1,1,0,0,1,1,0,0},
                    {0,1,1,1,1,1,1,1,1,0},
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1},
                    {0,1,1,1,1,1,1,1,1,0},
                    {0,0,1,1,1,1,1,1,0,0},
                    {0,0,0,1,1,1,1,0,0,0},
                    {0,0,0,0,1,1,0,0,0,0}
            };

            // Generate bricks based on the heart shape pattern
            for (int i = 0; i < heartShape.length; i++) {
                for (int j = 0; j < heartShape[i].length; j++) {
                    if (heartShape[i][j] == 1) {
                        bricks.add(new Brick(j * brickSize + startX, i * brickSize + startY, brickSize, brickSize,brickColor));
                    }
                }
            }

            return bricks;
    }

    public List<Brick> levelNine() {
        List<Brick> bricks = new ArrayList<>();
        Color brickColor = Color.GREEN;

        int brickSize = 50; // Square bricks
        int startX = 500; // Starting x-offset closer to the left side of the screen
        int startY = 50; // Starting y-offset, kept same as your previous setup

        // Diamond shape pattern
        int[][] diamondShape = {
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,1,1,1,0,0,0},
                {0,0,1,1,1,1,1,0,0},
                {0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,0},
                {0,0,1,1,1,1,1,0,0},
                {0,0,0,1,1,1,0,0,0},
                {0,0,0,0,1,0,0,0,0}
        };

        // Generate bricks based on the diamond shape pattern
        for (int i = 0; i < diamondShape.length; i++) {
            for (int j = 0; j < diamondShape[i].length; j++) {
                if (diamondShape[i][j] == 1) {
                    bricks.add(new Brick(j * brickSize + startX, i * brickSize + startY, brickSize, brickSize, brickColor));
                }
            }
        }

        return bricks;
    }


}

