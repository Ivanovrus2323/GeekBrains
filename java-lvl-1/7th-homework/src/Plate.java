import java.util.ArrayList;

public class Plate {

    public static ArrayList<Plate> plates = new ArrayList<Plate> ();

    private int food;

    public Plate(int food) {
        this.food = food;
        plates.add(this);
    }

    public void info() {
        System.out.println("Кол-во еды в миске: " + food);
    }

    /**
     * Добавляем еду в тарелку
     * @param food
     */
    public void addFood(int food) {
        this.food += food;
        System.out.println("Новое кол-во еды в миске: " + this.food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}