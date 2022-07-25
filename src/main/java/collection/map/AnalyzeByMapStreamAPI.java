package collection.map;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnalyzeByMapStreamAPI {
    public static double averageScore(List<Pupil> pupils) {
        return getSubjectStream(pupils)
                .collect(Collectors.averagingDouble(Subject::score));
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return getStreamLabelGroupSubject(pupils, Collectors.averagingDouble(Subject::score))
                .collect(Collectors.toList());

    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        Function<Pupil, Label> function = p ->  new Label(p.name(), p.subjects().stream()
                .mapToDouble(Subject::score)
                .average()
                .orElse(0));
        return  getStreamLabelPupil(pupils, function)
                .collect(Collectors.toList());
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Function<Pupil, Label> function = p -> new Label(p.name(), p.subjects().stream()
                .mapToDouble(Subject::score)
                .sum());
        return getStreamLabelPupil(pupils, function).max(Comparator.comparing(Label::score))
                .orElse(null);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return getStreamLabelGroupSubject(pupils, Collectors.summingDouble(Subject::score))
                .max(Comparator.comparing(Label::score))
                .orElse(null);
    }

    private static Stream<Subject> getSubjectStream(List<Pupil> pupils) {
        return pupils.stream().flatMap(p -> p.subjects().stream());
    }

    private static Stream<Label> getStreamLabelGroupSubject(List<Pupil> pupils,
                                                            Collector<Subject, ?, Double>
                                                                    collectorForGroup) {
        return getSubjectStream(pupils)
                .collect(Collectors.groupingBy(Subject::name, collectorForGroup))
                .entrySet()
                .stream()
                .map(e -> new Label(e.getKey(), e.getValue()));
    }

    private static Stream<Label> getStreamLabelPupil(List<Pupil> pupils,
                                                     Function<Pupil, Label> labelFunction) {
        return pupils.stream()
                .map(labelFunction);
    }
}
