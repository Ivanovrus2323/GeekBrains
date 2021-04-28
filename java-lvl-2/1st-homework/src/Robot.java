public class Robot implements Tracer {

    double jumpRestriction = 0;
    int runRestriction = 0;

    public Robot(double jumpRestriction, int runRestriction) {
        this.jumpRestriction = jumpRestriction;
        this.runRestriction = runRestriction;
    }

    public double getJumpRestriction() {
        return jumpRestriction;
    }

    public int getRunRestriction() {
        return runRestriction;
    }
}