package lambda.solutions;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        BiFunction<List<String>, String, Optional<String>> function = (ls, s) ->
            ls.contains(s) ? Optional.of(s) : Optional.empty();
        return function.apply(strings, value);
    }
}
