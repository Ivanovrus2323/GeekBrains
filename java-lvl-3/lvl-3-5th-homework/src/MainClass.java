import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {

    public static final int CARS_COUNT = 4;
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    public static final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch countDownLatch2 = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!\n");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        Thread[] threads = new Thread[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            threads[i] = new Thread(cars[i]);
            threads[i].start();
        }

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!\n");
        }).start();

        new Thread(() -> {
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }).start();
    }
}
