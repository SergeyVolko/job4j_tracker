package format;

import java.util.Calendar;

public class Format {
    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Привет! Я %s", name));
        System.out.println(String.format("Привет! Я %s, мой возраст: %s", name, age));
        System.out.println(String.format("Привет! Я %s, мой возраст: %d", name, age));
        System.out.println(String.format("Аргумент передан? %b", 55));
        System.out.println(String.format("Jo%c4j", 'b'));
        System.out.format("Строка1%nСтрока2");
    }

    public static void main(String[] args) {
        getGreeting("Елена", 33);
        System.out.println();
        getGreetingAndTime("Елена");
        System.out.println(String.format("Задаем число 0.99 - %f", 0.99));
        System.out.println(String.format("Задаем число 0.99 - %.2f", 0.99));
        System.out.println(String.format("%1$,+016.2f", 5000000.0000));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT",
                name, instance, instance));
    }
}
