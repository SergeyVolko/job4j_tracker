package stream.solutions;

import java.util.List;
import java.util.Optional;

public class FindFirstMethod {
    public static Optional<Integer> first(List<Integer> list) {
        return list.stream().findFirst();
    }
}
