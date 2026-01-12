import java.util.*;

class Boook {
    String title;

    Boook(String title) {
        this.title = title;
    }
}

public class SmartShelf {
//    Insertion Sort by book title
    public static void insertionSort(List<Boook> books) {
        for (int i = 1; i < books.size(); i++) {
            Boook key = books.get(i);
            int j = i - 1;

            while (j >= 0 && books.get(j).title.compareToIgnoreCase(key.title) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }
//    print shelf state
    public static void display(List<Boook> books) {
        System.out.print("Shelf: ");
        for (Boook b : books) {
            System.out.print(b.title + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Boook> shelf = new ArrayList<>();

        shelf.add(new Boook("Data Structures"));
        insertionSort(shelf);
        display(shelf);

        shelf.add(new Boook("Algorithms"));
        insertionSort(shelf);
        display(shelf);

        shelf.add(new Boook("Operating Systems"));
        insertionSort(shelf);
        display(shelf);

        shelf.add(new Boook("Java Programming"));
        insertionSort(shelf);
        display(shelf);

    }
}
