import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        firstExercise();


        PhoneDirectory phoneDirectory = new PhoneDirectory();

        fillPhoneDirectory(phoneDirectory);

        System.out.println(phoneDirectory.get("Pitts"));

    }

    // Задание 1
    public static void firstExercise() {
        String[] array = {"cinema","pony","diamond","material","flexible","mail","demonstrate","lonely","flexible","spider","main","variety","variety","slot","lonely","pony",};

        Set<String> array2 = new LinkedHashSet<>();
        Map<String, Integer> map = new LinkedHashMap();

        for(String s : array) {
            if (array2.add(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        for (String s : array2) {
            System.out.println(s);
        }

        System.out.println();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Слово \"" + entry.getKey() + "\" встречается раз: " + entry.getValue());
        }
    }

    public static void fillPhoneDirectory(PhoneDirectory phoneDirectory) {
        phoneDirectory.add("Singleton", "409-625-2895");
        phoneDirectory.add("Clark", "973-775-0924");
        phoneDirectory.add("Fox", "269-556-7863");
        phoneDirectory.add("Pitts", "601-464-0469");
        phoneDirectory.add("Singleton", "972-549-4546");
        phoneDirectory.add("Bishop", "406-668-2028");
        phoneDirectory.add("Pitts", "513-985-8383");
    }
}