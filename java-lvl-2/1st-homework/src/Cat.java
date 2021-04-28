public class Cat implements Tracer {

    private double jumpRestriction;
    private int runRestriction;

    public Cat(double jumpRestriction, int runRestriction) {
        this.jumpRestriction = jumpRestriction;
        this.runRestriction = runRestriction;
    }

    public boolean overcome(Obstacle obstacle) {
        if (obstacle.TYPE == ObstacleType.TREADMILL) {
            if(obstacle.VALUE <= runRestriction) {
                System.out.println("Трассер успешно преодолел беговую дорожку");
                return true;
            }
            System.out.println("Трассер не преодолел беговую дорожку");
        } else if (obstacle.TYPE == ObstacleType.WALL) {
            if(obstacle.VALUE <= jumpRestriction) {
                System.out.println("Трассер успешно преодолел стену");
                return true;
            }
            System.out.println("Трассер не преодолел стену");
        }
        return false;
    }

    public double getJumpRestriction() {
        return jumpRestriction;
    }

    public int getRunRestriction() {
        return runRestriction;
    }
}