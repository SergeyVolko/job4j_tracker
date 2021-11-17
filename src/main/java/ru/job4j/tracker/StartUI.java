package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (UserAction userAction : actions) {
            out.println(actions.indexOf(userAction) + ". " + userAction.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new CreateAction(output));
        userActions.add(new FindAllAction(output));
        userActions.add(new ReplaceAction(output));
        userActions.add(new DeleteAction(output));
        userActions.add(new FindByIdAction(output));
        userActions.add(new FindByNameAction(output));
        userActions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, userActions);
    }
}
