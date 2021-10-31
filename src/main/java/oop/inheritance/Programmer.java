package oop.inheritance;

public class Programmer extends Engineer {
    private  String activity;

    public Programmer(String name, String surname, String education, String birthday,
                      String activity) {
        super(name, surname, education, birthday);
        this.activity = activity;
    }

    public Project development(String name, int version) {
        return new Project(name, activity, version);
    }
}
