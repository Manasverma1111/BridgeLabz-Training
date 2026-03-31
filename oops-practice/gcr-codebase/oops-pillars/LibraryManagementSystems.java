import java.util.ArrayList;
import java.util.List;

interface Reservable {
    void reserveItem(String borrowerId);
    boolean checkAvailability();
}

abstract class LibraryItem {

    private int itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    private String borrowerId;

    public LibraryItem(int itemId, String title, String author) {

        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID    : " + itemId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Available  : " + (isAvailable ? "Yes" : "No"));
    }

    protected void assignBorrower(String borrowerId) {

        this.borrowerId = borrowerId;
        this.isAvailable = false;
    }

    protected void returnItem() {

        this.borrowerId = null;
        this.isAvailable = true;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }
}

class Bookkx extends LibraryItem implements Reservable {

    public Bookkx(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerId) {
        if (checkAvailability()) {
            assignBorrower(borrowerId);
            System.out.println("Book reserved successfully");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable {

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerId) {
        if (checkAvailability()) {
            assignBorrower(borrowerId);
            System.out.println("Magazine reserved successfully");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable {

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem(String borrowerId) {
        if (checkAvailability()) {
            assignBorrower(borrowerId);
            System.out.println("DVD reserved successfully");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystems {

    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();

        LibraryItem book = new Bookkx(101, "Clean Code", "Robert Martin");
        LibraryItem magazine = new Magazine(102, "Tech Monthly", "Editorial Team");
        LibraryItem dvd = new DVD(103, "Inception", "Christopher Nolan");

        items.add(book);
        items.add(magazine);
        items.add(dvd);

        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                if (r.checkAvailability()) {
                    r.reserveItem("USER123");
                }
            }

            System.out.println();
        }
    }
}
