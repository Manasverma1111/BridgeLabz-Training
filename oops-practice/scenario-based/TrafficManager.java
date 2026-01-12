import java.util.*;

class VehicleNode {
    String vehicleNo;
    VehicleNode next;

    VehicleNode(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        this.next = null;
    }
}

class Roundabout {
    private VehicleNode head = null;
//    add vehicle to roundabout
    public void addVehicle(String vehicleNo) {
        VehicleNode newNode = new VehicleNode(vehicleNo);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        VehicleNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }
//    remove vehicle from roundabout
    public void removeVehicle(String vehicleNo) {
        if (head == null) return;

        VehicleNode curr = head;
        VehicleNode prev = null;

        do {
            if (curr.vehicleNo.equals(vehicleNo)) {

                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) {
                        VehicleNode last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = curr.next;
                    }
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Print roundabout state
    public void display() {
        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        VehicleNode temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.vehicleNo + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}

// Queue for waiting vehicles
class VehicleQueue {
    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(String vehicleNo) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow: " + vehicleNo);
            return;
        }
        queue.add(vehicleNo);
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        }
        return queue.poll();
    }
}

public class TrafficManager {
    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);

        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");
        waitingQueue.enqueue("CAR-104"); //overflow

        String vehicle = waitingQueue.dequeue();
        if (vehicle != null)
            roundabout.addVehicle(vehicle);

        roundabout.addVehicle("CAR-201");
        roundabout.addVehicle("CAR-202");

        roundabout.display();

        roundabout.removeVehicle("CAR-201");
        roundabout.display();
    }
}
