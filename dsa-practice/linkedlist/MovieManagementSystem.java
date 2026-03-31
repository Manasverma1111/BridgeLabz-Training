package linkedlist;
import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieList {
    MovieNode head, tail;

    void addAtBeginning(String t, String d, int y, double r) {
        MovieNode n = new MovieNode(t, d, y, r);
        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    void addAtEnd(String t, String d, int y, double r) {
        MovieNode n = new MovieNode(t, d, y, r);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    void addAtPosition(int pos, String t, String d, int y, double r) {
        if (pos <= 1) {
            addAtBeginning(t, d, y, r);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        MovieNode n = new MovieNode(t, d, y, r);
        n.next = temp.next;
        n.prev = temp;

        if (temp.next != null)
            temp.next.prev = n;
        else
            tail = n;

        temp.next = n;
    }

    void removeByTitle(String title) {
        MovieNode temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head)
            head = head.next;
        if (temp == tail)
            tail = tail.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director))
                display(temp);
            temp = temp.next;
        }
    }

    void searchByRating(double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.rating == rating)
                display(temp);
            temp = temp.next;
        }
    }

    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
    }

    void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            display(temp);
            temp = temp.prev;
        }
    }

    void display(MovieNode m) {
        System.out.println(m.title + " | " + m.director + " | " + m.year + " | " + m.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();

        list.addAtBeginning("Inception", "Nolan", 2010, 9.0);
        list.addAtEnd("Interstellar", "Nolan", 2014, 8.6);
        list.addAtEnd("Avatar", "Cameron", 2009, 7.8);

        System.out.println("Forward Display:");
        list.displayForward();

        System.out.println("\nReverse Display:");
        list.displayReverse();

    }
}

