public class TextFormat {

    public static String formatParagraph(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }

        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("\\s*([.!?])\\s*", "$1 ");

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : str.toCharArray()) {
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String text = "  hello there.this   is 2026!how are you?   welcome in this new   era.  ";
        System.out.println(formatParagraph(text));
    }
}
