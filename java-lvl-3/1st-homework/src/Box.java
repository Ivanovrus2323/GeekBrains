import java.util.ArrayList;

public class Box<T extends Fruit> {
    private List<T> box;
    public String type;

    public Box() {
        this.type = T.name;
    }

    public void add(T fruit){
        box.add(fruit);
    }

    public void addAll(List<T> arrayList){
        box.addAll(arrayList);
    }

    public float getWeight() {
        return T.weight * box.size();
    }

    public boolean compare(Box<Fruit> box) {
        if (!type.equals(box.type)) return false;
        if (box.getWeight() == getWeight()) return true;
        return false;
    }

    public void pourInto(Box<T> box) {
        box.addAll(this.box);
        this.box.clear();
    }
}
