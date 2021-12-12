package stream.task5;

import org.junit.Test;
import stream.task3.Student;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentsTest  {
    @Test
    public void whenCollectMapThenMap() {
        List<Student> students = List.of(
                new Student(20, "Ivan"),
                new Student(20, "Ivan"),
                new Student(70, "Petr")
        );
        Map<String, Student> expected = Map.of(
                "Ivan", new Student(20, "Ivan"),
                "Petr", new Student(70, "Petr")
        );
        Map<String, Student> result = Students.collectMap(students);
        assertThat(expected, is(result));
    }
}