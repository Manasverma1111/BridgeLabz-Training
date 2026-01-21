package interfaces;
import java.util.*;

public class FrequencyOfElements {

    public static void main(String[] args) {

        List<String> elements = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> freqMap = new LinkedHashMap<>();

        for (String str : elements) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }
        System.out.println(freqMap);
    }
}
