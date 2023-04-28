package upr.io;

import java.util.Locale;
import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double r = input.nextDouble();
        String p = String.format(Locale.US, "%.1f", 4 * a);
        String l = String.format(Locale.US, "%.1f", 2 * Math.PI * r);
        String s = String.format(Locale.US, "%.1f", Math.PI * r * r);
        System.out.println(p);
        System.out.println(l);
        System.out.println(s);
    }
}
