package collection.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            count += subjects.size();
            for (Subject subject : subjects) {
                sum += subject.score();
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, List<Subject>> map = getMapSubjectsName(pupils);
        List<Label> labels = new ArrayList<>();
        int sum;
        for (Map.Entry<String, List<Subject>> entry : map.entrySet()) {
            sum = sumScoreSubjects(entry.getValue());
            labels.add(new Label(entry.getKey(), (double) sum / entry.getValue().size()));
        }
        return labels;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        List<Subject> subjects;
        for (Pupil pupil : pupils) {
            subjects = pupil.subjects();
            labels.add(new Label(pupil.name(),
                    (double) sumScoreSubjects(subjects) / subjects.size()));
        }
        return  labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int max = -1;
        int sum;
        Label result = null;
        for (Pupil pupil : pupils) {
            sum = sumScoreSubjects(pupil.subjects());
            if (max < sum) {
                result = new Label(pupil.name(), sum);
                max = sum;
            }
        }
        return result;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label result = null;
        Map<String, List<Subject>> map = getMapSubjectsName(pupils);
        int max = -1;
        int sum;
        for (Map.Entry<String, List<Subject>> entry : map.entrySet()) {
            sum = sumScoreSubjects(entry.getValue());
            if (max < sum) {
                result = new Label(entry.getKey(), sum);
                max = sum;
            }
        }
        return result;
    }

    private static Map<String, List<Subject>> getMapSubjectsName(List<Pupil> pupils) {
        Map<String, List<Subject>> map = new HashMap<>();
        String name;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                name = subject.name();
                if (map.containsKey(name)) {
                    map.get(name).add(subject);
                } else {
                    List<Subject> list = new ArrayList<>();
                    list.add(subject);
                    map.put(name, list);
                }
            }
        }
        return map;
    }

    private static int sumScoreSubjects(List<Subject> subjects) {
        int sum = 0;
        for (Subject subject : subjects) {
            sum += subject.score();
        }
        return sum;
    }
}
