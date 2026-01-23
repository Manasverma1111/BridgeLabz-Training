import java.time.LocalDate;
import java.util.*;

class Policy implements Comparable<Policy> {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policy(int policyNumber, String holderName, LocalDate expiryDate,
           String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    // uniqueness based on policy number
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return policyNumber == p.policyNumber;
    }

    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // sorting by expiry date
    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }

    public String toString() {
        return policyNumber + " (" + coverageType + ", " + expiryDate + ")";
    }
}

public class InsurancePolicy {

    public static void main(String[] args) {

        // 1. Store policies using different Sets
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        Policy p1 = new Policy(101, "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy(102, "Bob", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy(103, "Carol", LocalDate.now().plusDays(20), "Health", 4500);
        Policy p4 = new Policy(101, "Duplicate", LocalDate.now().plusDays(60), "Home", 6000);

        Collections.addAll(hashSet, p1, p2, p3, p4);
        Collections.addAll(linkedHashSet, p1, p2, p3, p4);
        Collections.addAll(treeSet, p1, p2, p3, p4);

        // 2. Retrieve policies

        System.out.println("All Unique Policies:");
        hashSet.forEach(System.out::println);

        System.out.println("\nPolicies Expiring in 30 Days:");
        LocalDate today = LocalDate.now();
        for (Policy p : hashSet) {
            if (!p.expiryDate.isAfter(today.plusDays(30))) {
                System.out.println(p);
            }
        }

        System.out.println("\nHealth Policies:");
        for (Policy p : hashSet) {
            if (p.coverageType.equals("Health")) {
                System.out.println(p);
            }
        }

        System.out.println("\nDuplicate Policy Numbers:");
        Set<Integer> seen = new HashSet<>();
        for (Policy p : Arrays.asList(p1, p2, p3, p4)) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p.policyNumber);
            }
        }

        // 3. Performance comparison (basic timing)
        comparePerformance(new HashSet<>(), "HashSet");
        comparePerformance(new LinkedHashSet<>(), "LinkedHashSet");
        comparePerformance(new TreeSet<>(), "TreeSet");
    }

    static void comparePerformance(Set<Policy> set, String name) {
        Policy p = new Policy(200, "Test", LocalDate.now(), "Auto", 1000);

        long start = System.nanoTime();
        set.add(p);
        set.contains(p);
        set.remove(p);
        long end = System.nanoTime();

        System.out.println(name + " time: " + (end - start) + " ns");
    }
}

