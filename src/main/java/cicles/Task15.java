package cicles;

import java.util.Collections;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task15 {
    public static void loop(int a, int b) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Старт")
                .add(IntStream.rangeClosed(a + 1, b)
                        .boxed()
                        .sorted(Collections.reverseOrder())
                        .filter(e -> e >= 100)
                        .map(String::valueOf)
                        .collect(joining(" ")))
                .add("Финиш");
        System.out.println(joiner);
    }

    public static void main(String[] args) {
        loop(-5, 104);
    }
}
