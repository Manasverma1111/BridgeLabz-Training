class BookDetails {

    String title;
    String author;
    double price;

    // Default constructor
    BookDetails() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    BookDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayBookDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
    }

    // Main method for testing
    public static void main(String[] args) {

        BookDetails book1 = new BookDetails(); // default constructor
        BookDetails book2 = new BookDetails("Harry Potter", "J.K. Rowling", 650.0);

        book1.displayBookDetails();
        System.out.println();

        book2.displayBookDetails();
    }
}
