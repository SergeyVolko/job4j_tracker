package cicles;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task26 {
    public static void loop(int num) {
        String res = IntStream.iterate(0, i -> i - 8)
                .limit(2L * num)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
        System.out.println(res);
    }
}
