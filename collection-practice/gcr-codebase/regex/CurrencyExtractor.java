package regex;
import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {

    public static void main(String[] args) {

        String text = "The price is $45.99, and the discount is 10.50.";

        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);

        List<String> values = new ArrayList<>();

        while (matcher.find()) {
            values.add(matcher.group());
        }

        System.out.println(String.join(", ", values));
    }
}

