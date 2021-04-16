import java.util.ArrayList;

public class Cat extends Animal {

    public static ArrayList<Cat> cats = new ArrayList<Cat> ();

    public static int count = 0;

    public Cat(String name, int appetite) {
        super(name, appetite);
        count++;
    }

    public Cat(String name) {
        this(name, -1);
    }

    public Cat() {
        this("Неизвестный кот", -1);
    }

    /**
     * Кормим всех котов
     */
    public static void eat() {
        for (Cat cat : cats) {
            if (Plate.plates.size() != 0) {
                for (Plate plate : Plate.plates) {
                    if (cat.satiety == false) {
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
}