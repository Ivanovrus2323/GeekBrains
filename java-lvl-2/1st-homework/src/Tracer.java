public interface Tracer {
    int runRestriction = 0;
    double jumpRestriction = 0;

    boolean overcome(Obstacle obstacle);

    default double getJumpRestriction() {
        return jumpRestriction;
    }

    default int getRunRestriction() {
        return runRestriction;
    }
}