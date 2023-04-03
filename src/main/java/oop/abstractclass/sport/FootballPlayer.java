package oop.abstractclass.sport;

public class FootballPlayer extends Sportsman {

    @Override
    void run() {
        System.out.println("Средняя скорость бега");
    }

    public void footKick() {
        System.out.println("Удар ногой по мячу");
    }
}
