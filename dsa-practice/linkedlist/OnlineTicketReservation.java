package linkedlist;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private TicketNode head;
    private TicketNode tail;

    public void addTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void removeTicket(int id) {
        if (head == null) return;

        TicketNode curr = head;
        TicketNode prev = tail;

        do {
            if (curr.ticketId == id) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else if (curr == head) {
                    head = head.next;
                    tail.next = head;
                } else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomer(String name) {
        if (head == null) return;

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Ticket not found.");
        }
    }

    public void searchByMovie(String movie) {
        if (head == null) return;

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Ticket not found.");
        }
    }

    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    private void displayTicket(TicketNode t) {
        System.out.println(t.ticketId + " | " + t.customerName + " | " + t.movieName + " | Seat: " + t.seatNumber + " | Time: " + t.bookingTime);
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Inception", "A10", "10:00 AM");
        system.addTicket(102, "Bob", "Inception", "A11", "10:05 AM");
        system.addTicket(103, "Charlie", "Interstellar", "B01", "10:10 AM");

        System.out.println("All Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Customer:");
        system.searchByCustomer("Alice");
        System.out.println("\nSearch by Movie:");
        system.searchByMovie("Inception");

        system.removeTicket(102);
        System.out.println("\nAfter Removal:");
        system.displayTickets();

        System.out.println("\nTotal Tickets: " + system.countTickets());
    }
}
