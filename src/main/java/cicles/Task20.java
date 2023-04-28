package cicles;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task20 {
    public static void loop() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Начало")
                .add(IntStream.iterate(1500, i -> i >= 1100, i -> i - 100)
                        .mapToObj(String::valueOf)
                        .collect(joining(" ")))
                .add("Конец");
        System.out.println(joiner);
    }
}
