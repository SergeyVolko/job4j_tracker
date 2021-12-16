package stream.solutions;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysStreamMethod {
    public static Stream<Integer> createStream(Integer[] data) {
        return Arrays.stream(data);
    }
}
