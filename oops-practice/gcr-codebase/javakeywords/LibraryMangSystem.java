class Bookks {

    static String libraryName = "Egmore Library";
    final String isbn;
    String title;
    String author;
//    constructor using this
    Bookks(String title, String author, String isbn) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {

        System.out.println("Library Name: " + libraryName);
    }

    // 4. instanceof check before displaying details
    void displayDetails(Object obj) {

        if (obj instanceof Bookks) {
            Bookks b = (Bookks) obj;
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);
            System.out.println("ISBN: " + b.isbn);
        }
    }
}

public class LibraryMangSystem {
    public static void main(String[] args) {

        Bookks book1 = new Bookks("Effective Java","Joshua Bloch","978-0134685991");

        Bookks.displayLibraryName();
        book1.displayDetails(book1);
    }
}
