package lambda.task8;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            int otherTotal = total;
            total = add(
                    () ->  otherTotal + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}

