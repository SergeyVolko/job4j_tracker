package lambda.solutions;

import java.util.Optional;

public class OptionalOrlElse {
    public static Integer orElse(Optional<Integer> optional) {
        return optional.orElse(-1);
    }
}
