package cicles;

import java.util.Arrays;

public class Task56 {
    public static void loop(int[] array) {
        long count = Arrays.stream(array)
                .filter(i -> i > array[0])
                .count();
        System.out.println(count);
    }
}
