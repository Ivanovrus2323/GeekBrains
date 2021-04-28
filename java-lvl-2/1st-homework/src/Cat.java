public class Cat implements Tracer {

    private double jumpRestriction = 0;
    private int runRestriction = 0;

    public Cat(double jumpRestriction, int runRestriction) {
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