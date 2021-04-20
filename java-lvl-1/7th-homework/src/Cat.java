import java.util.ArrayList;

public class Cat extends Animal {

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
}
