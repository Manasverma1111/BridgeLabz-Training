package linear_binary_search;

public class FirstWordInSentence {

    public static String firstWord(String[] sentences, String findWord) {

        for (String sent : sentences) {
            if (sent.contains(findWord)) {
                return sent;
            }
        }

        return "not found";
    }

    public static void main(String[] args) {

        String[] sentences = {"Hello welcome back", "doing linear search"};
        String searchWord = "linear";

        String res = firstWord(sentences, searchWord);
        System.out.print(res);
    }
}
