package linkedlist;

class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean available;
    BookNode next;
    BookNode prev;

    BookNode(int bookId, String title, String author, String genre, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManager {
    private BookNode head;
    private BookNode tail;

    public void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtEnd(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp == tail) {
            addAtEnd(id, title, author, genre, available);
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, available);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void removeByBookId(int id) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitle(String title) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private void displayBook(BookNode b) {
        System.out.println(b.bookId + " | " + b.title + " | " + b.author + " | " + b.genre + " | Available: " + b.available);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManager lib = new LibraryManager();

        lib.addAtEnd(101, "1984", "George Orwell", "Fiction", true);
        lib.addAtBeginning(100, "The Alchemist", "Paulo Coelho", "Fiction", true);
        lib.addAtPosition(2, 102, "Clean Code", "Robert Martin", "Programming", false);

        lib.displayForward();

        lib.searchByTitle("1984");
        lib.searchByAuthor("Paulo Coelho");
        lib.updateAvailability(102, true);
        lib.removeByBookId(100);
        lib.displayReverse();

        System.out.println("Total Books: " + lib.countBooks());
    }
}
