package stream.solutions;

import java.util.List;
public class AllMatchMethod {
    public static boolean check(List<String> list) {
        return list.stream()
                .allMatch(s -> s.length() > 3);
    }
}
