import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Obstacle> obstacles = getObstacles();
        List<Tracer> tracers = getTracers();

        for (Tracer tracer : tracers) {
            if (passObstacleCourse(obstacles, tracer)) {
                System.out.println("Трассер успешно прошел полосу припятствий");
            } else {
                System.out.println("Трасссер не прошел полосу припятствий");
            }
            System.out.println();
        }

    }

    public static boolean passObstacleCourse(List<Obstacle> obstacles, Tracer tracer) {
        for (Obstacle obstacle : obstacles) {
            if (!tracer.overcome(obstacle)) {
                return false;
            }
        }
        return true;
    }

    public static List<Obstacle> getObstacles() {
        // Создаем объекты полосы препятствий
        Treadmill treadmill1 = new Treadmill(300);
        Treadmill treadmill2 = new Treadmill(100);
        Treadmill treadmill3 = new Treadmill(200);
        Treadmill treadmill4 = new Treadmill(600);

        Wall wall1 = new Wall(1);
        Wall wall2 = new Wall(1.1);
        Wall wall3 = new Wall(0.5);
        Wall wall4 = new Wall(0.2);
        Wall wall5 = new Wall(0.4);

        // Создаем массив объектов полосы препятствий
        List<Obstacle> obstacles = new ArrayList<Obstacle>();
        obstacles.add(wall1);
        obstacles.add(treadmill1);
        obstacles.add(wall2);
        obstacles.add(treadmill3);
        obstacles.add(wall3);
        obstacles.add(treadmill2);
        obstacles.add(wall4);
        obstacles.add(treadmill3);
        obstacles.add(wall5);
        obstacles.add(treadmill4);

        return obstacles;
    }

    public static List<Tracer> getTracers() {
        // Создаем трассеров
        Person person1 = new Person(0.7, 1000);
        Person person2 = new Person(0.6, 900);
        Person person3 = new Person(0.9, 1800);

        Robot robot1 = new Robot(1.6, 7000);
        Robot robot2 = new Robot(3, 15000);
        Robot robot3 = new Robot(2.3, 11000);

        Cat cat1 = new Cat(1.2, 500);
        Cat cat2 = new Cat(1, 400);
        Cat cat3 = new Cat(1.4, 300);

        // Создаем массив трассеров
        List<Tracer> tracers = new ArrayList<Tracer>();

        tracers.add(person1);
        tracers.add(person2);
        tracers.add(person3);

        tracers.add(robot1);
        tracers.add(robot2);
        tracers.add(robot3);

        tracers.add(cat1);
        tracers.add(cat2);
        tracers.add(cat3);

        return tracers;
    }
}