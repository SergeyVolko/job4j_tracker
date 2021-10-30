package oop.inheritance;

public class Doctor extends Profession {
    private Patient patient;
    private int countPatient;

    public Doctor(String name, String surname, String education, String birthday, Patient patient) {
        super(name, surname, education, birthday);
        this.patient = patient;
    }

    public Diagnosis getDiagnosis() {
        return this.patient.getDiagnosis();
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void addPatient() {
        this.countPatient++;
    }

    public int getCountPatient() {
        return countPatient;
    }
}
