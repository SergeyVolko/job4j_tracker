package upr.io;

import java.util.Arrays;

public class Task15 {
    public static void main(String[] args) {
        String source = "+!?";
        System.out.println(String.valueOf(source.charAt(0)).repeat(3));
        System.out.println(String.valueOf(source.charAt(1)).repeat(4));
        System.out.print(String.valueOf(source.charAt(2)).repeat(2));
    }
}
