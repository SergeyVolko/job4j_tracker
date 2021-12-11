package lambda.solutions;

import java.util.Optional;
import java.util.function.BiFunction;

public class OptionalGetAndIsPresent {
    public static int get(int[] data, int el) {
        Optional<Integer> optional = indexOf(data, el);
        return optional.isEmpty() ? -1 : optional.get();
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        BiFunction<int[], Integer, Optional<Integer>> function = (d, e) -> {
            for (int i = 0; i < d.length; i++) {
                if (d[i] == e) {
                    return Optional.of(i);
                }
            }
            return Optional.empty();
        };
        return function.apply(data, el);
    }
}
