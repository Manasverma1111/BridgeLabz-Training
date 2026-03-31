import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {

        // Store votes
        Map<String, Integer> voteMap = new HashMap<>();

        // Maintains insertion order
        Map<String, Integer> voteOrder = new LinkedHashMap<>();

        castVote(voteMap, voteOrder, "Alice");
        castVote(voteMap, voteOrder, "Bob");
        castVote(voteMap, voteOrder, "Alice");
        castVote(voteMap, voteOrder, "Carol");
        castVote(voteMap, voteOrder, "Bob");

        System.out.println("Votes (Insertion Order):");
        System.out.println(voteOrder);

        Map<String, Integer> sortedResults = new TreeMap<>(voteMap);

        System.out.println("\nVotes (Sorted Order):");
        System.out.println(sortedResults);
    }

    static void castVote(Map<String, Integer> voteMap, Map<String, Integer> voteOrder, String candidate) {

        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate));
    }
}

