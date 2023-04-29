package cicles;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task51 {
    public static void loop(int n, int m) {
        int x = n;
        int y = m;
        if (x > y) {
            x = m;
            y = n;
        }
        int p = x;
        int q = y;
        String res = IntStream.rangeClosed(p, q)
                .map(i -> i % 2 == 0 ? 0 : i * i)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
        System.out.println(res);
    }
}
