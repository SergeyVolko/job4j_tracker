package oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int arg = 5;
        System.out.println(sum(arg));
        System.out.println(minus(arg));
        System.out.println(calculator.multiply(arg));
        System.out.println(calculator.divide(arg));
        System.out.println(calculator.sumAllOperation(arg));
    }
}
