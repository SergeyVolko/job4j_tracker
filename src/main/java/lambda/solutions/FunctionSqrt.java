package lambda.solutions;

import java.util.function.Function;

public class FunctionSqrt {
    public static double calculate(double x) {
        return calculate(n -> Math.sqrt(n), x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }
}