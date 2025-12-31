class Bookk {

    String title;
    String author;
    double price;
    boolean available;

    // Constructor
    Bookk(String title, String author, double price) {

        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }
//    method to borrow a book
    void borrowBook() {

        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry, the book is currently not available.");
        }
    }
//    method to display book details
    void displayBookDetails() {

        System.out.println("Title        : " + title);
        System.out.println("Author       : " + author);
        System.out.println("Price        : " + price);
        System.out.println("Availability : " + (available ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {

        Bookk book = new Bookk("Harry Potter", "J.K. Rowling", 570);

        book.displayBookDetails();
        System.out.println();
        book.borrowBook();
        System.out.println();
        book.displayBookDetails();
    }
}
