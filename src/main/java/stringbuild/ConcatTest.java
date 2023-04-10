package stringbuild;

public class ConcatTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "Job4j";
        for (int index = 0; index < 9999; index++) {
            str = str + index;
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("Job4j");
        for (int index = 0; index < 9999; index++) {
            stringBuilder.append(index);
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
    }
}
