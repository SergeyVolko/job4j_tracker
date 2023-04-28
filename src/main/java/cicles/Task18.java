package cicles;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task18 {
    public static void loop() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Начало")
                .add(IntStream.rangeClosed(10, 19)
                        .filter(e -> e % 2 == 0)
                        .mapToObj(e -> e % 4 == 0
                                ? String.valueOf(e).concat("#") : String.valueOf(e))
                        .collect(joining(" ")))
                .add("Конец");
        System.out.println(joiner);
    }
}
