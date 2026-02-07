package singleton;

public class LibraryCatalog {
    private static LibraryCatalog instance;

    private LibraryCatalog() {}

    public static synchronized LibraryCatalog getInstance() {
        if(instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton LibraryCatalog instance created");
    }

    public static void main(String[] args) {
        LibraryCatalog catalog1 = LibraryCatalog.getInstance();
        LibraryCatalog catalog2 = LibraryCatalog.getInstance();

        catalog1.showMessage();
        System.out.println("Same instance: " + (catalog1 == catalog2));
    }
}