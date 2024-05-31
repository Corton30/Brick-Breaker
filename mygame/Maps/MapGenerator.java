package mygame.Maps;

import mygame.props.Brick;
import java.util.List;

public class MapGenerator {
    private MapLevels levels = new MapLevels();

    public int getMaxLevel() {
        return 5;  // Assuming 5 levels as shown in your original implementation
    }

    public List<Brick> generateMap(int level) {
        switch (level) {
            case 1: //Big Bar
                return levels.levelOne();
            case 2:
                return levels.levelTwo();
            case 3:// Letter "A"
                return levels.levelThree();
            case 4:// Random bricks
                return levels.levelFour();
            case 5:// Spiral pattern
                return levels.levelFive();
            case 6:
                return levels.levelSix();
            case 7:
                return levels.levelSeven();
            case 8:
                return levels.levelEight();
            case 9:
                return levels.levelNine();
            default:
                throw new IllegalArgumentException("Invalid level: " + level);
        }
    }
}
