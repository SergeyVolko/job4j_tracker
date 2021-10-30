package oop.inheritance;

public class Dentist extends Doctor {
    private String typeDiagnosis;

    public Dentist(String name, String surname, String education, String birthday,
                   Patient patient) {
        super(name, surname, education, birthday, patient);
        this.typeDiagnosis = "DENTAL";
    }

    public void dentalTreatment(Patient patient, String nameDiagnosis) {
        patient.setDiagnosis(new Diagnosis(nameDiagnosis, typeDiagnosis));
        addPatient();
    }
}
