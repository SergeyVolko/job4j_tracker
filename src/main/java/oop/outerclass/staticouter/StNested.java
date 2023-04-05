package oop.outerclass.staticouter;

public class StNested {

    private static int num1;
    private int num2;

    public StNested() { }

    static class StaticNested {

        void setStaticOuterVariable(int value) {
            num1 = value;
        }

    }

    public static void main(String[] args) {
        num1 = 1;
        StNested.StaticNested n = new StaticNested();
        StaticNested nested = new StaticNested();
        nested.setStaticOuterVariable(2);
        n.setStaticOuterVariable(3);
        System.out.println("num1 = " + num1);
    }

}
