package stream.solutions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysStreamForPrimitive {
    public static IntStream createStream(int[] data) {
        return Arrays.stream(data);
    }
}
