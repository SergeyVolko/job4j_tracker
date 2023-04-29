package cicles;

import java.util.stream.IntStream;

public class Task57 {
    public static void loop(int[] array) {
        long count = IntStream.range(1, array.length)
                .filter(i -> array[i - 1] < array[i])
                .count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] rsl = {4, 3, 2, 1};
        loop(rsl);
    }
}
