package regex;
import java.util.regex.*;

public class EmailExtraction {

    public static void main(String[] args) {

        String text = "Contact us at support@example.com and info@company.org";

        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

