public class Obstacle {
    public final double VALUE;
    public final ObstacleType TYPE;

    public Obstacle(double value, ObstacleType type) {
        VALUE = value;
        TYPE = type;
    }
}

class Treadmill extends Obstacle {
    public Treadmill(int value) {
        super((double) value, ObstacleType.TREADMILL);
    }
}

class Wall extends Obstacle {
    public Wall(double value) {
        super(value, ObstacleType.WALL);
    }
}