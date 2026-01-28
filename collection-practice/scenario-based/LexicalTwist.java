import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LexicalTwist {

    private static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

    private static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        if (!isValidWord(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (!isValidWord(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }

        // Check if second is reverse of first (case-insensitive)
        String reversedFirst = new StringBuilder(first).reverse().toString();

        if (reversedFirst.equalsIgnoreCase(second)) {

            // Step 1–4: reverse → lowercase → replace vowels with '@'
            String transformed = reversedFirst.toLowerCase()
                    .replaceAll("[aeiou]", "@");

            System.out.println(transformed);

        } else {

            String combined = (first + second).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for (char ch : combined.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (isVowel(ch)) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }

            if (vowelCount == consonantCount) {
                System.out.println("Vowels and consonants are equal");
                return;
            }

            boolean printVowels = vowelCount > consonantCount;
            Set<Character> result = new LinkedHashSet<>();

            for (char ch : combined.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (printVowels && isVowel(ch)) {
                        result.add(ch);
                    } else if (!printVowels && !isVowel(ch)) {
                        result.add(ch);
                    }
                }
                if (result.size() == 2) break;
            }

            StringBuilder output = new StringBuilder();
            for (char ch : result) {
                output.append(ch);
            }

            System.out.println(output);
        }

        sc.close();
    }
}
