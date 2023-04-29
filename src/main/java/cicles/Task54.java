package cicles;

import java.util.Arrays;

public class Task54 {
    public static void loop(int[] array) {
        long count = Arrays.stream(array)
                .filter(e -> e > 0)
                .count();
        System.out.println(count);
    }
}
