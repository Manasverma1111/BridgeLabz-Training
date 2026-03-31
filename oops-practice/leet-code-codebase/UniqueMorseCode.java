import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCode {
    public static int uniqueMorse(String[] words) {

        String[] morseCode = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> transform = new HashSet<>();
        for (String word : words) {
            StringBuilder morse = new StringBuilder();
            for (char ch : word.toCharArray()) {
                morse.append(morseCode[ch - 'a']);
            }
            transform.add(morse.toString());
        }

        return transform.size();
    }

    public static void main(String[] args) {

        String[] words = {"gin","zen","gig","msg"};
        int res = uniqueMorse(words);
        System.out.println(res);
    }
}
