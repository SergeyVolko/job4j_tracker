package lambda.solutions;

import java.util.function.Consumer;

public class ConsumerAndThen {
    public static Consumer<String> consumer(String input) {
        Consumer<String> print = s -> System.out.print(s);
        Consumer<String> ln = s -> System.out.println();
        return print.andThen(ln);
    }
}

