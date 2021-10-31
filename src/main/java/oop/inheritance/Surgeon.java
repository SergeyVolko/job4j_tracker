package oop.inheritance;

public class Surgeon extends Doctor {
    private String typeDiagnosis;

    public Surgeon(String name, String surname, String education, String birthday,
                   Patient patient, String typeDiagnosis) {
        super(name, surname, education, birthday, patient);
        this.typeDiagnosis = typeDiagnosis;
    }

    public void operation(Patient patient, String nameDiagnosis) {
        patient.setDiagnosis(new Diagnosis(nameDiagnosis, typeDiagnosis));
        addPatient();
    }
}
