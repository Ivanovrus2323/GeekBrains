public class Dog extends Animal {

    public static int count = 0;

    private static final int maxRunDistance = 500;
    private static final int maxSwimDistance = 10;

    public Dog(String name) {
        super(name, maxRunDistance, maxSwimDistance);
        count++;
    }

    @Override
    public void run(int distance){
        super.run(distance);
    }

    @Override
    public void swim(int distance){
        super.swim(distance);
    }
}