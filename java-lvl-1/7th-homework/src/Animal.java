public class Animal {

    public static int count = 0;

    private int maxRunDistance;
    private int maxSwimDistance;
    private boolean satiety;
    private int age;

    private String name;

    public Animal(String name, int age, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        satiety = false;
        count++;
    }

    public Animal(String name, int maxRunDistance) {
        this(name, -1, maxRunDistance, -1);
    }

    public Animal(int age, String name) {
        this(name, age, -1, -1);
    }

    public Animal(String name) {
        this(name, -1, -1, -1);
    }

    public Animal() {
        this("Неизвестное животное", -1, -1, -1);
    }



    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.age = -1;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        satiety = false;
        count++;
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
}