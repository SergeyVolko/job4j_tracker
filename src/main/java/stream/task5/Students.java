package stream.task5;

import stream.task3.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Students {
    public static Map<String, Student> collectMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        e -> e
                ));
    }
}
