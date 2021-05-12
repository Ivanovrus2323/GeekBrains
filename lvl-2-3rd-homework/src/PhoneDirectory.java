import java.util.*;

public class PhoneDirectory {
    private Map<String, List<String>> map = new HashMap<>();

    public List<String> get(String secondName) {
        return map.get(secondName);
    }

    public void add(String secondName, String phoneNumber) {
        List<String> phoneNumbersList;

        phoneNumbersList = (map.containsKey(secondName)) ? map.get(secondName) : new ArrayList<>();
        phoneNumbersList.add(phoneNumber);

        map.put(secondName, phoneNumbersList);
    }
}