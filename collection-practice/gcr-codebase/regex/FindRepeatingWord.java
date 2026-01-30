package regex;
import java.util.regex.*;
import java.util.*;

public class FindRepeatingWord {

    public static void main(String[] args) {

        String text = "This is is a repeated repeated word test.";

        Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatingWords = new LinkedHashSet<>();

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}

