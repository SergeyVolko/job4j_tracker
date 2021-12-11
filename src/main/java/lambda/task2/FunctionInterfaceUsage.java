package lambda.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        /**
         * 1. Supplier
         */
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supSet = () -> new HashSet<>(list);
        Set<String> strings = supSet.get();
        for (String s : strings) {
            System.out.println(s);
        }
        /**
         * 2. Consumer и BiConsumer.
         */
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());
        BiConsumer<String, String> biConsumer = (s, s1) -> System.out.println(s + s1);
        biConsumer.accept(sup.get(), " and Second String");
        BiConsumer<Integer, String> biConsumer1 = (s, s1) -> System.out.println(s + s1);
        int i = 1;
        for (String s : strings) {
            biConsumer1.accept(i++, " is " + s);
        }
        /**
         * 3. Predicate (BiPredicate).
         */
        Predicate<String> predicate = (s -> (s.isEmpty()));
        System.out.println("Строка пустая: " + predicate.test(""));
        System.out.println("Строка пустая: " + predicate.test("test"));
        BiPredicate<String, Integer> predicate1 = (s, n) -> s.contains(n.toString());
        /**
         * 4. Function (BiFunction).
         */
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));
        BiFunction<String, Integer, String> biFunc = (s, n) -> s.concat(" ").concat(n.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));
        /**
         * 5. UnaryOperator и BinaryOperator.
         */
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: "
                + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: "
                + builder.apply(new StringBuilder("tset rof gnirtS")));
        BinaryOperator<StringBuilder> builder1 = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + builder1.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
