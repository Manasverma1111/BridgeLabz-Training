import java.util.Scanner;

public class FlipKey {

    public static String genPassword(String str) {

        if (str == null || str.length() < 6 || !str.matches("^[A-Za-z]+$")) {
            return "";
        }

        str = str.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch % 2 != 0) {
                sb.append(ch);
            }
        }

        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            if (i % 2 == 0) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String input = sc.nextLine();

        String result = genPassword(input);

        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }
    }
}