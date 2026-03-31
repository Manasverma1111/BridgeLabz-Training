import java.util.*;

class Ticket {
    int price;

    Ticket(int price) {
        this.price = price;
    }
}

public class EventManager {
//    quick Sort
    public static void quickSort(List<Ticket> tickets, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(tickets, low, high);
            quickSort(tickets, low, pivotIndex - 1);
            quickSort(tickets, pivotIndex + 1, high);
        }
    }
//    partitioning
    private static int partition(List<Ticket> tickets, int low, int high) {
        int pivot = tickets.get(high).price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets.get(j).price <= pivot) {
                i++;
                Collections.swap(tickets, i, j);
            }
        }
        Collections.swap(tickets, i + 1, high);
        return i + 1;
    }
//    print tickets
    public static void display(List<Ticket> tickets) {
        System.out.print("Ticket Prices: ");
        for (Ticket t : tickets) {
            System.out.print(t.price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Ticket> tickets = new ArrayList<>();

        tickets.add(new Ticket(1500));
        tickets.add(new Ticket(500));
        tickets.add(new Ticket(2500));
        tickets.add(new Ticket(1000));
        tickets.add(new Ticket(800));

        quickSort(tickets, 0, tickets.size() - 1);
        display(tickets);
//        top 3 cheapest tickets
        System.out.print("Cheapest Tickets: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(tickets.get(i).price + " ");
        }
    }
}
