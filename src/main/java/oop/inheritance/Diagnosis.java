package oop.inheritance;

public class Diagnosis {
    private String name;
    private String typeDiagnosis;

    public Diagnosis(String name, String typeDiagnosis) {
        this.name = name;
        this.typeDiagnosis = typeDiagnosis;
    }

    public String getName() {
        return name;
    }
}
