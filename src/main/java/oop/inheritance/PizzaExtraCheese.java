package oop.inheritance;

public class PizzaExtraCheese extends Pizza{
    @Override
    public String name() {
        return super.name().concat(" + extra cheese");
    }
}
