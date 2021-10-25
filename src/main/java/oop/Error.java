package oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);

    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(false, 1, "Second error.");
        Error third = new Error(true, 2, "Third error.");
        first.printInfo();
        System.out.println();
        second.printInfo();
        System.out.println();
        third.printInfo();
    }
}
