package oop.inheritance;

public class Programmer extends Engineer {
    private  String activity;

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
        this.activity = "SOFT";
    }

    public Project development(String name, int version) {
        return new Project(name, activity, version);
    }
}
