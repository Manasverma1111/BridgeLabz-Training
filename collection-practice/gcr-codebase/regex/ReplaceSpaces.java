package regex;
public class ReplaceSpaces {

    public static void main(String[] args) {

        String input = "This   is   an   example   with   multiple   spaces.";
        String result = input.replaceAll("\\s+", " ");

        System.out.println(result);
    }
}

