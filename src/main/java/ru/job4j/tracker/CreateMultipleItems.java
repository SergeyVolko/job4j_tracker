package ru.job4j.tracker;

public class CreateMultipleItems implements UserAction {
    private final Output out;

    public CreateMultipleItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new multiple Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws Exception {
        out.println("=== Create a new multiple Item ====");
        int quantity = input.askInt("Enter quantity items: ");
        for (int i = 1; i <= quantity; i++) {
            tracker.add(new Item("Item" + i));
        }
        out.println("Добавлено заявок: " + quantity);
        return true;
    }
}
