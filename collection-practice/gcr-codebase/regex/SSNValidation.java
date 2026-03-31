package regex;
import java.util.regex.*;

public class SSNValidation {

    public static void main(String[] args) {

        String text = "My SSN is 123-45-6789.";

        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("Invalid SSN");
        }
    }
}

