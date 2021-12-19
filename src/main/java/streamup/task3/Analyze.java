package streamup.task3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D))
                ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)
                ))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()
                ))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("Default", 0D));

    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingInt(Subject::getScore)
                ))
                .entrySet().stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("Default", 0));
    }
}

