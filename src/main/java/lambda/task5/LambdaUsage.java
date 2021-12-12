package lambda.task5;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "one",
                "three",
                "two",
                "five",
                "four"
        };
        Comparator<String> cmpDescSize  = (left, right) ->
                Integer.compare(right.length(), left.length());
        Arrays.sort(strings, (left, right) -> {
            System.out.println(left + ":" + right);
            return cmpDescSize.compare(left, right);
        });
        System.out.println(Arrays.toString(strings));
    }
}
