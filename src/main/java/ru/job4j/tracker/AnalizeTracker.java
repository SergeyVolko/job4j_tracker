package ru.job4j.tracker;

import java.util.List;

public class AnalizeTracker {

    public static void main(String[] args) throws Exception {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateMultipleItems(output),
                new ReplaceAction(output),
                new DeleteMultipleItems(output),
                new FindAllAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
