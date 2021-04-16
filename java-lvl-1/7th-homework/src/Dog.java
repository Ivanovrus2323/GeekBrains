import java.util.ArrayList;

public class Dog extends Animal {

    public static ArrayList<Dog> dogs = new ArrayList<Dog> ();

    public static int count = 0;

    public Dog(String name, int appetite) {
        super(name, appetite);
        count++;
    }

    public Dog(String name) {
        this(name, -1);
    }

    public Dog() {
        this("Неизвестный пес", -1);
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
}