public class Application {

    public static void main(String[] args) {
        
        Animal animal1 = new Animal("Чебурашка", 1000, 1);

        Cat cat1 = new Cat("Василий");
        Cat cat2 = new Cat("Арес");

        Dog dog1 = new Dog("Аарон");
        Dog dog2 = new Dog("Адлер");
        Dog dog3 = new Dog("Арчи");

        System.out.println();

        cat1.swim(54);
        cat1.run(147);
        cat1.run(634);

        System.out.println();

        dog1.swim(125);
        dog1.run(156);
        dog1.run(857);

        System.out.println();
        System.out.println(Animal.count);
        System.out.println(Dog.count);
        System.out.println(Cat.count);
    }

}