package regex;
public class CensorBadWords {

    public static String censor(String text) {

        String badWordsRegex = "\\b(damn|stupid)\\b";
        return text.replaceAll(badWordsRegex, "****");
    }

    public static void main(String[] args) {

        String input = "This is a damn bad example with some stupid words.";
        System.out.println(censor(input));
    }
}

