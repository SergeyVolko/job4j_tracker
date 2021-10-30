package oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("Java", 500);
        books[1] = new Book("C++", 1000);
        books[2] = new Book("Clean code", 300);
        Library.showBooks(books);
        Book temp = books[0];
        books[0] = books[2];
        books[2] = temp;
        Library.showBooks(books);
        Library.showCleanCode(books);
    }

    private static void showBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCount());
        }
    }

    private static void showCleanCode(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " - " + books[i].getCount());
            }
        }
    }
}
