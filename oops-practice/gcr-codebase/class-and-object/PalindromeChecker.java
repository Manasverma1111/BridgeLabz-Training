class PalindromeChecker {

    String text;
//    method to check palindrome
    boolean isPalindrome() {

        String newText = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = "";

        for (int i = newText.length() - 1; i >= 0; i--) {
            reversed = reversed + newText.charAt(i);
        }

        return newText.equals(reversed);
    }
//    method to display result
    void displayResult() {

        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }

    public static void main(String[] args) {

        PalindromeChecker p1 = new PalindromeChecker();
        p1.text = "A man a plan a canal Panama";
        p1.displayResult();

        PalindromeChecker p2 = new PalindromeChecker();
        p2.text = "Hello";
        p2.displayResult();
    }
}

