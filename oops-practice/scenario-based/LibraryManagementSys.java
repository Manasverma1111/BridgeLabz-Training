class Bookss {
    String title;
    String author;
    boolean isAvailable;

    Bookss(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

public class LibraryManagementSys {
//    display all books
    static void displayBooks(Bookss[] books) {

        System.out.println("Library Books:");
        for (Bookss book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author + ", Status: " + (book.isAvailable ? "Available" : "Checked Out")
            );
        }
    }
//    search books by partial title
    static void searchBook(Bookss[] books, String keyword) {

        boolean found = false;
        System.out.println("Search Results for \"" + keyword + "\":");

        for (Bookss book : books) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Title: " + book.title + ", Author: " + book.author + ", Status: " + (book.isAvailable ? "Available" : "Checked Out"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }
//    checkout a book
    static void checkoutBook(Bookss[] books, String title) {
        for (Bookss book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("Book is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Main method
    public static void main(String[] args) {

        // Store books in an array
        Bookss[] books = {
                new Bookss("Java Programming", "James Gosling"),
                new Bookss("Clean Code", "Robert C. Martin"),
                new Bookss("Data Structures", "Mark Allen Weiss"),
                new Bookss("Effective Java", "Joshua Bloch")
        };

        displayBooks(books);
        System.out.println();

        searchBook(books, "java");
        System.out.println();

        checkoutBook(books, "Clean Code");
        System.out.println();

        displayBooks(books);
    }
}
