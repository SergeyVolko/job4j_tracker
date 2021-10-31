package oop.inheritance;

public class Builder extends Engineer {
    private  String activity;

    public Builder(String name, String surname, String education, String birthday,
                   String activity) {
        super(name, surname, education, birthday);
        this.activity = activity;
    }

    public Project build(String name, int version) {
        return new Project(name, activity, version);
    }
}
