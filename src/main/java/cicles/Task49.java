package cicles;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task49 {
    public static void loop(int n, int m) {
        int x = n;
        int y = m;
        if (x > y) {
            x = m;
            y = n;
        }
        int p = x;
        int q = y;
        String res = IntStream.iterate(p % 2 == 0 ? p : p + 1, i -> i <= q, i -> i + 2)
                .mapToObj(String::valueOf)
                .collect(joining("+"));
        System.out.println(res);
    }

    public static void main(String[] args) {
        loop(10, 3);
    }
}
