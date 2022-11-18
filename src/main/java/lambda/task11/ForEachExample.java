package lambda.task11;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ОДИН", "ДВА", "ТРИ");
        strings.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}
