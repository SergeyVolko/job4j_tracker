package upr.io;

public class Task16 {
    public static void main(String[] args) {
        String source = "+!?";
        System.out.print(String.valueOf(source.charAt(0)).repeat(3)
                .concat(String.valueOf(source.charAt(1)).repeat(4))
                .concat(String.valueOf(source.charAt(2)).repeat(2)));
    }
}
