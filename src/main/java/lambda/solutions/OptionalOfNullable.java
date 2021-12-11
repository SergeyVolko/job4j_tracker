package lambda.solutions;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        for (String str : strings) {
            if (Objects.equals(str, value)) {
                return Optional.ofNullable(value);
            }
        }
        return Optional.empty();
    }
}
