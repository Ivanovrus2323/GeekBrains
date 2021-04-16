import java.util.ArrayList;

public class Animal {

    public static ArrayList<Animal> animals = new ArrayList<Animal> ();

    public static int count = 0;

    private String name;
    private int age;
    private int appetite;
    private int maxRunDistance;
    private int maxSwimDistance;
    protected boolean satiety;

    public Animal(String name, int appetite, int age, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.age = age;
        this.appetite = (appetite <= 0) ? 0 : appetite;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        satiety = (appetite <= 0) ? true : false;
        count++;
    }

    public Animal(String name, int appetite) {
        this(name, appetite, -1, -1, -1);
    }

    public Animal(int age, String name, int appetite) {
        this(name, appetite, age, -1, -1);
    }

    public Animal(int age, String name) {
        this(name, 0, age, -1, -1);
    }

    public Animal(String name) {
        this(name, 0, -1, -1, -1);
    }

    public Animal() {
        this("Неизвестное животное", 0, -1, -1, -1);
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this(name, 0, -1, maxRunDistance, maxSwimDistance);
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

    public void run(int distance){
        validateDistance(distance);

        if (distance > maxRunDistance && maxRunDistance != -1) {
            System.out.println(name + " пробежал " + maxRunDistance + " метров и устал.");
        } else {
            System.out.println(name + " пробежал " + distance + " метров.");
        }
    }

    public void swim(int distance){
        validateDistance(distance);

        if (distance > maxSwimDistance && maxSwimDistance != -1) {
            System.out.println(name + " проплыл " + maxSwimDistance + " метров и устал.");
        } else {
            System.out.println(name + " проплыл " + distance + " метров.");
        }
    }

    /**
     * Проверка пути на отрицательное значение
     * @param distance
     */
    private void validateDistance(int distance){
        if (distance < 0) {
            throw new IllegalArgumentException("Расстояние не может быть отрицательным");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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