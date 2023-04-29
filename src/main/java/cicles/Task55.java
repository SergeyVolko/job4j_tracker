package cicles;

import java.util.Arrays;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;

public class Task55 {
    public static void loop(int[] array) {
        var map = Arrays.stream(array)
                .boxed()
                .collect(groupingBy(i -> Math.abs(i % 2), counting()));
        System.out.printf("Четных: %d, нечетных: %d", map.getOrDefault(0, 0L),
                map.getOrDefault(1, 0L));
    }
}
