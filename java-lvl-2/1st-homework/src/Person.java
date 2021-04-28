public class Person implements Tracer {

    private double jumpRestriction = 0;
    private int runRestriction = 0;

    public Person(double jumpRestriction, int runRestriction) {
        super();
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