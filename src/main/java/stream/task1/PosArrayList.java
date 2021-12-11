package stream.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PosArrayList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-3, 2, -1, 6, 8);
        List<Integer> posList = list.stream().filter(i -> i > 0).collect(Collectors.toList());
        System.out.println(posList);
    }
}
