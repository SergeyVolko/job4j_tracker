package oop.outerclass.localanonim;

public class Parrot extends Bird {

    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println("Попугай пролетает над лужайкой");
    }

}
