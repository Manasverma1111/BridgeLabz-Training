package java_streams;
import java.io.*;
import java.util.*;

public class CountWords {

    public static void main(String[] args) {

        String filePath = "input.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Step 1: Read file and count words
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                // Normalize case and remove punctuation
                String[] words = line
                        .toLowerCase()
                        .replaceAll("[^a-z0-9 ]", "")
                        .split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word,
                                wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
            return;
        }

        // Step 2: Sort and display top 5 words
        System.out.println("Top 5 most frequent words:\n");

        wordCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(entry ->
                        System.out.println(entry.getKey() + " → " + entry.getValue()));
    }
}
