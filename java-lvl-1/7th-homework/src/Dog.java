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
}