package lambda.exceptlamda;

import java.util.List;
import java.util.function.Consumer;

public class ExceptionMethod {

    static <T> Consumer<T> throwingExceptionConsumerWrapper(
            ThrowingExceptionConsumer<T, Exception> throwingExceptionConsumer) {

        return x -> {
            try {
                throwingExceptionConsumer.accept(x);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    static void someMethod(int a, int b) {
        System.out.println(a / b);
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        integerList.forEach(
                throwingExceptionConsumerWrapper(n -> someMethod(n, 3)));

    }
}
