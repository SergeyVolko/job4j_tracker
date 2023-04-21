package lambda.task10;

import java.util.function.*;

public class ConstructorRefMain {
    public static void main(String[] args) {
        FuncInterface modelConstructor = Model::new;
        Model model = modelConstructor.function("Example");
        System.out.println("Значение равно: " + model.getName());
        Supplier<Model> createModel = Model::new;
        Model defModel = createModel.get();
        System.out.println("Значение равно: " + defModel.getName());
    }
}