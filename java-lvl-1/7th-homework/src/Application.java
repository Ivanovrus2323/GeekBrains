import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        
        Animal animal1 = new Animal("Чебурашка", 10);

        Cat cat1 = new Cat("Василий", 41);
        Cat cat2 = new Cat("Арес", 70);

        Dog dog1 = new Dog("Аарон");
        Dog dog2 = new Dog("Адлер");
        Dog dog3 = new Dog("Арчи");

        System.out.println();


        /**
         * Задание 5
         */
        Plate plate1 = new Plate(100);

        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(cat1);
        cats.add(cat2);

        for (Cat cat : cats) {
            cat.eat(plate1);
        }
    }
}