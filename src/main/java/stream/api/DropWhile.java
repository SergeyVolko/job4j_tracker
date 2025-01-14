package stream.api;

import java.util.List;

public class DropWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 1, 2).stream()
                .dropWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}
