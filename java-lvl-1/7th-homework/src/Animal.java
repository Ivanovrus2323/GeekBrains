import java.util.ArrayList;

public class Animal {

    public static ArrayList<Animal> animals = new ArrayList<Animal> ();

    public static int count = 0;

    private String name;
    private int appetite;
    protected boolean satiety;

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = (appetite <= 0) ? 0 : appetite;
        satiety = (appetite <= 0) ? true : false;
        count++;
    }

    public Animal(String name) {
        this(name, 0);
    }

    public Animal() {
        this("Неизвестное животное", 0);
    }

    /**
     * Кормим всех животных
     */
    public void eat() {
        for (Animal animal : animals) {
            if (Plate.plates.size() != 0) {
                for (Plate plate : Plate.plates) {
                    if (satiety == false) {
                        animal.eat(plate);
                    } else {
                        break;
                    }
                }
            } else {
                throw new IllegalArgumentException("Мисок нет");
            }
        }

        for (Animal animal : animals) {
            animal.isSatiety();
        }
    }

    public void eat(Plate plate) {
        if (satiety = true) {

            System.out.println(name + " не голоден");
        } else if (plate.getFood() >= appetite && satiety == false) {
            plate.setFood(plate.getFood() - appetite);
            appetite = 0;
            satiety = true;

            System.out.println(name + " наелся");
        } else if (plate.getFood() < appetite && satiety == false) {
            appetite = appetite - plate.getFood();
            plate.setFood(0);
            satiety = false;

            System.out.println(name + " съел всю еду, но не наелся");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        System.out.println((satiety == false) ? name + " не голоден" : name + " голоден");
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }
}