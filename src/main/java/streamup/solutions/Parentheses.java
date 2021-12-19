package streamup.solutions;

import java.util.stream.Stream;

public class Parentheses {
    public static boolean valid(char[] data) {
        return Stream.of(data).allMatch(chars -> {
            int left = 0;
            int right = 0;
            for (var ch : chars) {
                if (ch == '(') {
                    left++;
                } else {
                    right++;
                }
                if (right > left) {
                    break;
                }
            }
            return left == right;
        });
    }
}
