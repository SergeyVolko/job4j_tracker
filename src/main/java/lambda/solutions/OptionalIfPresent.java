package lambda.solutions;

import java.util.Optional;
import java.util.function.Function;

public class OptionalIfPresent {
    public static void ifPresent(int[] data) {
        max(data).ifPresent((d) -> System.out.println("Max: " + d));
    }

    private static Optional<Integer> max(int[] data) {
        Function<int[], Optional<Integer>> function = (d) -> {
            if (d.length == 0) {
                return Optional.empty();
            }
            int max = d[0];
            for (int i : d) {
                max = Math.max(i, max);
            }
            return Optional.of(max);
        };
        return function.apply(data);
    }
}
