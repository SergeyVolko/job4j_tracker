package gcanalize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnalizeGC {

    private File file;
    private String name;

    public AnalizeGC(File file, String name) {
        this.file = file;
        this.name = name;
    }

    private GCCharacteristicsSTW getCharacteristics(String[] arrStr) {
        double time = Double.parseDouble(arrStr[0].substring(1, arrStr[0].indexOf("s")));
        double pause = Double.parseDouble(arrStr[arrStr.length - 1]
                .substring(0, arrStr[arrStr.length - 1].length() - 2));
        return new GCCharacteristicsSTW(time, pause);
    }

    private List<GCCharacteristicsSTW> getList() {
        List<GCCharacteristicsSTW> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
          list = reader.lines().filter(s -> "ms".equals(s.substring(s.length() - 2)))
                    .map(s -> getCharacteristics(s.split(" ")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void infoGC() {
        List<GCCharacteristicsSTW> list = getList();
        double pauseSum = list.stream().map(e -> e.pause / 1000).reduce(Double::sum).get();
        double totalTime = list.get(list.size() - 1).time;
        double maxPause = list.stream().map(e -> e.pause / 1000).reduce(Double::max).get();
        System.out.println("-".repeat(50));
        System.out.printf("Тип GC: %s%n", name);
        System.out.printf("Общая пауза: %fs%n", pauseSum);
        System.out.printf("Время работы программы: %fs%n", totalTime);
        System.out.printf("Пропускная способность: %f%n", (1 - pauseSum / totalTime) * 100);
        System.out.printf("Время сборки: %f%n", (pauseSum / totalTime) * 100);
        System.out.printf("Количество пауз: %d%n", list.size());
        System.out.printf("Среднее время задержки: %fs%n", pauseSum /  list.size());
        System.out.printf("Самая большая пауза: %fs%n", maxPause);
        System.out.println("-".repeat(50));
    }

    private static class GCCharacteristicsSTW {

        private final double time;
        private final double pause;

        public GCCharacteristicsSTW(double time, double pause) {
            this.time = time;
            this.pause = pause;
        }

        @Override
        public String toString() {
            return "GCCharacteristicsSTW{"
                    + "time=" + time
                    + ", pause=" + pause
                    + '}';
        }

        public double getTime() {
            return time;
        }

        public double getPause() {
            return pause;
        }

    }

    public static void main(String[] args) {
        AnalizeGC analizeG1GC =
                new AnalizeGC(new File("src/main/java/log/g1"), "G1");
        analizeG1GC.infoGC();
        AnalizeGC analizeSerial =
                new AnalizeGC(new File("src/main/java/log/serial"), "Serial");
        analizeSerial.infoGC();
        AnalizeGC analizeParSerial =
                new AnalizeGC(new File("src/main/java/log/parallel"), "Parallel");
        analizeParSerial.infoGC();
    }
}
