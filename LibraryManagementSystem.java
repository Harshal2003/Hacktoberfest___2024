import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + (isIssued ? "Yes" : "No");
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook() {
        System.out.println("Enter Book ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter Book Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Book Author:");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    private static void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void issueBook() {
        System.out.println("Enter Book ID to Issue:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Book book : books) {
            if (book.getId() == id && !book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued successfully.");
                return;
            } else if (book.isIssued()) {
                System.out.println("Book is already issued.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void returnBook() {
        System.out.println("Enter Book ID to Return:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Book book : books) {
            if (book.getId() == id && book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned successfully.");
                return;
            } else if (!book.isIssued()) {
                System.out.println("Book is not issued.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
