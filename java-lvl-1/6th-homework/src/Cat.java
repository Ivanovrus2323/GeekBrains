public class Cat extends Animal {

    public static int count = 0;

    private static final int maxRunDistance = 200;

    public Cat(String name) {
        super(name, maxRunDistance);
        count++;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
    }
}