package oop.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese{
    @Override
    public String name() {
        return super.name().concat(" + extra tomato");
    }
}
