package collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sergnsbm@mail.ru", "Igor Ivanovich Smirnov");
        map.put("varg@mail.ru", "Aleksandr Nicolaevich Petrov");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
