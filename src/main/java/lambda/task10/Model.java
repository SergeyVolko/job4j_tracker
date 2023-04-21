package lambda.task10;

public class Model {
    private String name;

    Model() {
        this.name = "Default name";
    }

    Model(String str) {
        name = str;
    }

    String getName() {
        return name;
    }
}
