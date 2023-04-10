package varargs;

public class VarArgs {
    public String text(String a) {
        return "";
    }

    public String text(String a, String b) {
        return "";
    }

    public String text(String a, String b, String c) {
        return "";
    }

    public static String textArr(String[] strings) {
        return "";
    }

    public static String textArgs(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder + " Количество соединенных элементов: " + strings.length;
    }

    public static String textArgs(int x, String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static String textArgs(String str) {
        return str;
    }

    public static void main(String[] args) {
        String[] strings = {"aaa", "bbb", "ccc"};
        String str = textArr(strings);
        System.out.println(str);

        System.out.println(textArgs());
        System.out.println(textArgs("aaa"));
        System.out.println(textArgs("aaa", "bbb", "ccc"));
        System.out.println(textArgs("aaa", "bbb", "ccc", "ddd", "eee"));
        System.out.println(textArgs(30, "aaa", "bbb"));
    }
}
