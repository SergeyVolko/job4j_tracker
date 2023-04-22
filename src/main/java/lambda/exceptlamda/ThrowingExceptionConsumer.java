package lambda.exceptlamda;

@FunctionalInterface
public interface ThrowingExceptionConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}
