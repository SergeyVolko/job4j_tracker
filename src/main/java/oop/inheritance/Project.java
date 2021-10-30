package oop.inheritance;

public class Project {
    private String name;
    private final String type;
    private int version;

    public Project(String name, String type, int version) {
        this.name = name;
        this.type = type;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
