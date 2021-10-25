package oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(5);
        System.out.println("load first: " + first.load);
        System.out.println("load second: " + second.load);
        first.exchange(second);
        System.out.println("load first: " + first.load);
        System.out.println("load second: " + second.load);
    }
}
