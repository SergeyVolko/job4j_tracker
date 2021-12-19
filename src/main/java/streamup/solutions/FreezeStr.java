package streamup.solutions;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        String[] lefts = left.split("");
        String[] rights = right.split("");
        Map<String, Integer> leftMap = createMap(lefts);
        Map<String, Integer> rightMap = createMap(rights);
        return leftMap.entrySet().containsAll(rightMap.entrySet());
    }

    public static Map<String, Integer> createMap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            if (map.containsKey(str)) {
                map.computeIfPresent(str, (k, v) -> v + 1);
            } else {
                map.put(str, 1);
            }
        }
        return map;
    }
}
