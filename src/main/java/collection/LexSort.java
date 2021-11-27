package collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int l = Integer.parseInt(left.split("\\.")[0]);
        int r = Integer.parseInt(right.split("\\.")[0]);
        return Integer.compare(l, r);
    }

    public static void main(String[] args) {
        String test = "10. Task.";
        String[] t = test.split("\\.");
        System.out.println(Arrays.toString(t));
    }
}
