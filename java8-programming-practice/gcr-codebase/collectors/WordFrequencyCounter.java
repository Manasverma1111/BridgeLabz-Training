package collectors;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String parag = "keep running and keep rising";

        Map<String, Integer> wordCount = Arrays.stream(parag.split("\\s+")).collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
        System.out.println(wordCount);
    }
}
