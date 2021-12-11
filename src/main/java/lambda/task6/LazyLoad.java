package lambda.task6;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLoad {

    public static void main(String[] args) {
        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}
