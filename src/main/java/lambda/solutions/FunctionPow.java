package lambda.solutions;

import java.util.function.Function;

public class FunctionPow {
    public static double calculate(double x) {
        return calculate(n -> n * n, x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }
}
