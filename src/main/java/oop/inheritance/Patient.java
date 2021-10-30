package oop.inheritance;

public class Patient {
    private String name;
    private Diagnosis diagnosis;

    public Patient(String name, Diagnosis diagnosis) {
        this.name = name;
        this.diagnosis = diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
