public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
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