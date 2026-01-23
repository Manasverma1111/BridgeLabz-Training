package interfaces;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class WordFrequency {

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";

        HashMap<String, Integer> map = new LinkedHashMap<>();

        input = input.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = input.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println(map);
    }
}
