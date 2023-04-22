package stream.task2;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(e -> e.getStandard() - e.getActual() >= 0)
                .filter(e -> e.getStandard() - e.getActual() <= 3)
                .map(e -> (new Label(e.getName(), e.getPrice() / 2)).toString())
                .collect(Collectors.toList());
    }
}
