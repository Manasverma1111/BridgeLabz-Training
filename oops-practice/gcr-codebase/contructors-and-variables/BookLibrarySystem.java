class Books {

    // Access modifiers
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    Books(String ISBN, String title, String author) {

        this.ISBN = ISBN;
        this.title = title;
        setAuthor(author);
    }

    // Public setter for author
    public void setAuthor(String author) {

        this.author = author;
    }

    // Public getter for author
    public String getAuthor() {

        return author;
    }

    // Method to display book details
    void displayBookDetails() {

        System.out.println("ISBN   : " + ISBN);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
    }
}

// Child class
class EBook extends Books {

    double fileSize; // in MB

    // Constructor
    EBook(String ISBN, String title, String author, double fileSize) {

        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    // Method demonstrating access to public and protected members
    void displayEBookDetails() {

        System.out.println("E-Book Details");
        System.out.println("ISBN     : " + ISBN);   // public access
        System.out.println("Title    : " + title);  // protected access
        System.out.println("Author   : " + getAuthor()); // private via getter
        System.out.println("FileSize : " + fileSize + " MB");
    }
}

// Main class
public class BookLibrarySystem {

    public static void main(String[] args) {

        EBook ebook = new EBook(
                "978-0134685991",
                "Effective Java",
                "Joshua Bloch",
                5.2
        );

        ebook.displayBookDetails();
        System.out.println();

        ebook.displayEBookDetails();
    }
}
