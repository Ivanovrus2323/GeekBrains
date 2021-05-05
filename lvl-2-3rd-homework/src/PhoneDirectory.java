import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, ArrayList<String>> map = new LinkedHashMap();

    public ArrayList<String> get(String secondName) {
        return map.get(secondName);
    }

    public void add(String secondName, String phoneNumber) {
        ArrayList<String> phoneNumbersList;

        phoneNumbersList = (map.containsKey(secondName)) ? map.get(secondName) : new ArrayList<>();
        phoneNumbersList.add(phoneNumber);

        map.put(secondName, phoneNumbersList);
    }
}