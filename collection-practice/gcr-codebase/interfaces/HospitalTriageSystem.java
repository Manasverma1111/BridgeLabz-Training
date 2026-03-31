package interfaces;

import java.util.PriorityQueue;
import java.util.Queue;

class Patient {

    String name;
    int severity;

    Patient (String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
public class HospitalTriageSystem {

    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);
        queue.add(new Patient("Alice", 3));
        queue.add(new Patient("Bob", 5));
        queue.add(new Patient("Jhon", 2));

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p.name);
        }

    }
}
