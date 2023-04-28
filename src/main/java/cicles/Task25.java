package cicles;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task25 {
    public static void loop(int num) {
        String res = IntStream.range(0, num)
                .map(i -> 4 * i + 7)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
        System.out.println(res);
    }

    public static void main(String[] args) {
        loop(5);
    }
}
