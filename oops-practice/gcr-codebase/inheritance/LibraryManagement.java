class Bookkss {
    protected String title;
    protected int publicationYear;

    Bookkss(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Bookkss {
    private String name;
    private String bio;

    Author(String title, int publicationYear, String name, String bio) {

        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {

        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {

        Author bookWithAuthor = new Author("Harry Potter", 2009, "J.K. Rowling", "Harry Potter and the Prisoners of Azkaban");
        bookWithAuthor.displayInfo();
    }
}
