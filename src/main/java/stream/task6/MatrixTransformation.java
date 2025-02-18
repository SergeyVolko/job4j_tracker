package stream.task6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixTransformation {
    public static List<Integer> transform(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
