import java.util.ArrayList;

public class Cat extends Animal {

    public static ArrayList<Cat> cats = new ArrayList<Cat> ();

    public static int count = 0;

    private static final int maxRunDistance = 200;
    private static final int maxSwimDistance = 0;

    public Cat(String name) {
        super(name, maxRunDistance, maxSwimDistance);
        count++;
    }

    /**
     * Кормим всех котов
     */
    @Override
    public void eat() {
        for (Cat cat : cats) {
            if (Plate.plates.size() != 0) {
                for (Plate plate : Plate.plates) {
                    if (satiety == false) {
                        cat.eat(plate);
                    } else {
                        break;
                    }
                }
            } else {
                throw new IllegalArgumentException("Мисок нет");
            }
        }

        for (Cat cat : cats) {
            cat.isSatiety();
        }
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