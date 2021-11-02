package oop.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void drive() {
        System.out.println("Мы едем.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Число пассажиров: " + count);
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 50;
    }

    @Override
    public void move() {
        System.out.println("Автобус едет по дороге.");
    }
}
