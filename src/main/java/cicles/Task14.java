package cicles;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class Task14 {
    public static void loop(int a, int b) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Старт")
                .add(IntStream.range(a, b)
                        .filter(e -> e >= 10)
                        .mapToObj(String::valueOf)
                        .collect(joining(" ")))
                .add("Финиш");
        System.out.println(joiner);
    }

    public static void main(String[] args) {
        loop(-16, 15);
    }
}
