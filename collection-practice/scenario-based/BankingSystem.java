import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {

        // HashMap → AccountNumber -> Balance
        Map<Integer, Integer> accounts = new HashMap<>();
        accounts.put(101, 5000);
        accounts.put(102, 3000);
        accounts.put(103, 7000);

        // withdrawal requests (AccountNumber, Amount)
        Queue<int[]> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.offer(new int[]{101, 2000});
        withdrawalQueue.offer(new int[]{102, 1000});
        withdrawalQueue.offer(new int[]{103, 4000});

        // Process withdrawals
        while (!withdrawalQueue.isEmpty()) {
            int[] request = withdrawalQueue.poll();
            int accNo = request[0];
            int amount = request[1];

            int balance = accounts.get(accNo);
            if (balance >= amount) {
                accounts.put(accNo, balance - amount);
                System.out.println("Withdrawal successful: " + accNo);
            } else {
                System.out.println("Insufficient balance: " + accNo);
            }
        }

        // Sort customers by balance
        TreeMap<Integer, List<Integer>> sortedByBalance = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            sortedByBalance.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("\nSorted by Balance:");
        System.out.println(sortedByBalance);
    }
}

