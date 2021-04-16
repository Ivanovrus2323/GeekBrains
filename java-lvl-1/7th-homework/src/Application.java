public class Application {

    public static void main(String[] args) {
        
        Animal animal1 = new Animal("Чебурашка", 10);

        Cat cat1 = new Cat("Василий");
        Cat cat2 = new Cat("Арес");

        Dog dog1 = new Dog("Аарон");
        Dog dog2 = new Dog("Адлер");
        Dog dog3 = new Dog("Арчи");

        System.out.println();

        Plate plate = new Plate(100);
    }
}