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
            case 1:
                return levels.levelOne();
            case 2:
                return levels.levelTwo();
            case 3:
                return levels.levelThree();
            case 4:
                return levels.levelFour();
            case 5:
                return levels.levelFive();
            default:
                throw new IllegalArgumentException("Invalid level: " + level);
        }
    }
}
