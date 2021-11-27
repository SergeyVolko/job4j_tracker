package collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int length = Math.min(o1.length(), o2.length());
        int rsl = 0;
        for (int i = 0; i < length && rsl == 0; i++) {
            rsl = Character.compare(o1.charAt(i), o2.charAt(i));
        }
        return rsl == 0 ? o1.length() - o2.length() : rsl;
    }
}
