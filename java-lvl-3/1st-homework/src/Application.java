import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String[] array = new String[] {"1", "2", "3", "4", "5"};

        array = change(array,  2, 4);
        ArrayList<String> list = toArrayList(array);
    }

    // Первое задание
    public static <T> T[] change(T[] array, int firstPosition, int secondPosition) {
        T temp;

        temp = array[firstPosition];
        array[firstPosition] = array[secondPosition];
        array[secondPosition] = temp;

        return array;
    }

    // Второе задание
    public static <T> ArrayList<T> toArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }
}