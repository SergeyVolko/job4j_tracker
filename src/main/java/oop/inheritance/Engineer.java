package oop.inheritance;

public class Engineer extends Profession {
    private Project project;

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void improve(int version) {
        project.setVersion(version);
    }
}
