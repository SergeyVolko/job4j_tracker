package ru.job4j.tracker;

import java.util.List;

public class GCStartUI {

    private final Output out;

    public GCStartUI(Output out) {
        this.out = out;
    }

    private static String[] scenario(int count) {
        int adding = 2 * count;
        int replaces = 3 * count;
        int shows = 5;
        int findById = 2 * count;
        int deleteId = 2 * count;
        int length = adding + replaces + shows + findById + deleteId;
        String[] scenario = new String[length + 1];
        int step = adding;
        int id = 1;
        for (int i = 0; i < step; i += 2) {
            scenario[i] = "0";
            scenario[i + 1] = "item" + (id++);
        }
        id = 1;
        for (int i = step; i < step + replaces; i += 3) {
            scenario[i] = "1";
            scenario[i + 1] = String.valueOf(id);
            scenario[i + 2] = "replace" + (id);
            id++;
        }
        step += replaces;
        for (int i = step; i < step + shows; i++) {
            scenario[i] = "3";
        }
        step += shows;
        id = 1;
        for (int i = step; i < step + findById; i += 2) {
            scenario[i] = "4";
            scenario[i + 1] = String.valueOf(id++);
        }
        step += findById;
        id = 1;
        for (int i = step; i < step + deleteId; i += 2) {
            scenario[i] = "2";
            scenario[i + 1] = String.valueOf(id++);
        }
        scenario[scenario.length - 1] = "6";
        return scenario;
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new StubInput(scenario(5)));
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new FindAllAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new ExitAction(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
