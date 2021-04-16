import java.util.ArrayList;

public class Dog extends Animal {

    public static ArrayList<Dog> dogs = new ArrayList<Dog> ();

    public static int count = 0;

    private static final int maxRunDistance = 500;
    private static final int maxSwimDistance = 10;

    public Dog(String name) {
        super(name, maxRunDistance, maxSwimDistance);
        count++;
    }

    /**
     * Кормим всех собак
     */
    @Override
    public void eat() {
        for (Dog dog : dogs) {
            if (Plate.plates.size() != 0) {
                for (Plate plate : Plate.plates) {
                    if (satiety == false) {
                        dog.eat(plate);
                    } else {
                        break;
                    }
                }
            } else {
                throw new IllegalArgumentException("Мисок нет");
            }
        }

        for (Dog dog : dogs) {
            dog.isSatiety();
        }
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