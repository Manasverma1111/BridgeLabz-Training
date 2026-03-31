public class TextAnalyse {
//    method to count words
    public static int countWords(String paragraph) {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return 0;
        }
        String[] words = paragraph.trim().split("\\s+");
        return words.length;
    }
//    method to find the longest word
    public static String findLongestWord(String paragraph) {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        String[] words = paragraph.trim().split("\\s+");
        String longestWord = "";

        for (String word : words) {
            // remove punctuation
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
//    method to replace a word (case-insensitive)
    public static String replaceWord(String paragraph, String oldWord, String newWord) {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        return paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {

        String paragraph = "  You are powerful. Life is versatile.  ";

        System.out.println("Word Count: " + countWords(paragraph));
        System.out.println("Longest Word: " + findLongestWord(paragraph));
        String updatedParagraph = replaceWord(paragraph, "java", "Python");
        System.out.println("Updated Paragraph:");
        System.out.println(updatedParagraph.trim());
    }
}
