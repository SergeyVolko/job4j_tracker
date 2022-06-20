package ru.job4j.tracker;

public class DeleteMultipleItems implements UserAction {
    private final Output out;

    public DeleteMultipleItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete multiple item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete multiple item ===");
        boolean result = true;
        int quantity = input.askInt("Enter quantity items: ");
        for (int i = 1; i <= quantity; i++) {
            if (!store.delete(i)) {
                out.println("Ошибка удаления заявок.");
                result = false;
                break;
            }
        }
        return result;
    }
}
