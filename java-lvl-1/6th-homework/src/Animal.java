public class Animal {

    public static int count = 0;

    private int maxRunDistance;
    private int maxSwimDistance;

    private String name;

    public Animal(String name) {
        this.name = name;
        this.maxRunDistance = -1;
        this.maxSwimDistance = -1;
        count++;
    }

    public Animal(String name, int maxRunDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = -1;
        count++;
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
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
}