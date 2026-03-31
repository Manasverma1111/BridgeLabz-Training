import java.time.LocalDate;
import java.util.*;

class Policyy {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    Policyy(int policyNumber, String holderName, LocalDate expiryDate,
           String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | " + expiryDate;
    }
}

public class InsurancePolicySystem {

    public static void main(String[] args) {

        // 1. Store policies in different Maps
        Map<Integer, Policyy> hashMap = new HashMap<>();
        Map<Integer, Policyy> linkedHashMap = new LinkedHashMap<>();
        TreeMap<LocalDate, List<Policyy>> treeMap = new TreeMap<>();

        Policyy p1 = new Policyy(101, "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policyy p2 = new Policyy(102, "Bob", LocalDate.now().plusDays(40), "Auto", 3000);
        Policyy p3 = new Policyy(103, "Alice", LocalDate.now().plusDays(20), "Home", 4500);
        Policyy p4 = new Policyy(104, "Carol", LocalDate.now().minusDays(5), "Health", 4000);

        addPolicy(hashMap, linkedHashMap, treeMap, p1);
        addPolicy(hashMap, linkedHashMap, treeMap, p2);
        addPolicy(hashMap, linkedHashMap, treeMap, p3);
        addPolicy(hashMap, linkedHashMap, treeMap, p4);

        // 2. Retrieve and manipulate policies

        System.out.println("Retrieve Policy 102:");
        System.out.println(hashMap.get(102));

        System.out.println("\nPolicies Expiring in 30 Days:");
        listExpiringSoon(hashMap);

        System.out.println("\nPolicies for Alice:");
        listByHolder(hashMap, "Alice");

        System.out.println("\nRemoving Expired Policies...");
        removeExpired(hashMap);

        System.out.println("\nRemaining Policies:");
        hashMap.values().forEach(System.out::println);
    }

    static void addPolicy(Map<Integer, Policyy> hashMap,
                          Map<Integer, Policyy> linkedHashMap,
                          TreeMap<LocalDate, List<Policyy>> treeMap,
                          Policyy p) {

        hashMap.put(p.policyNumber, p);
        linkedHashMap.put(p.policyNumber, p);

        treeMap
                .computeIfAbsent(p.expiryDate, k -> new ArrayList<>())
                .add(p);
    }

    static void listExpiringSoon(Map<Integer, Policyy> map) {
        LocalDate today = LocalDate.now();
        for (Policyy p : map.values()) {
            if (!p.expiryDate.isAfter(today.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    static void listByHolder(Map<Integer, Policyy> map, String holder) {
        for (Policyy p : map.values()) {
            if (p.holderName.equals(holder)) {
                System.out.println(p);
            }
        }
    }

    static void removeExpired(Map<Integer, Policyy> map) {
        LocalDate today = LocalDate.now();
        map.values().removeIf(p -> p.expiryDate.isBefore(today));
    }
}

