package stream.solutions;

import java.util.List;
import java.util.stream.Collectors;
public class SortedMethod {
    public static List<String> sorted(List<String> strings) {
        return strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }
}
