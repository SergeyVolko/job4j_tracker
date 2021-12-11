package lambda.task5;

import java.util.Arrays;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "one",
                "three",
                "two",
                "five",
                "four"
        };
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, (left, right) -> {
            System.out.println(left + ":" + right);
            return right.compareTo(left);
        });
        System.out.println(Arrays.toString(strings));
    }
}
