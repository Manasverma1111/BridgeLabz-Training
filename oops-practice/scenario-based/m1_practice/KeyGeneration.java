package m1_practice;

import java.util.Scanner;

public class KeyGeneration {

    public static void genKey(String str) {

        if (str == null || str.isEmpty()) {
            System.out.println("Invalid Input (empty string)");
            return;
        }

        if (str.length() < 6) {
            System.out.println("Invalid Input (length < 6)");
            return;
        }
        if (str.contains(" ")) {
            System.out.println("Invalid Input (contains space)");
            return;
        }
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                System.out.println("Invalid Input (contains digits)");
                return;
            }
            if (!Character.isLetter(ch)) {
                System.out.println("Invalid Input (contains special character)");
                return;
            }
        }

        String validStr = str.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (char ch : validStr.toCharArray()) {
            if (ch % 2 != 0) {
                sb.append(ch);
            }
        }

        sb.reverse();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if (i % 2 == 0) {
                res.append(Character.toUpperCase(ch));
            } else {
                res.append(ch);
            }
        }

        if (sb.isEmpty()) {
            System.out.println("Invalid Input (empty string)");
        } else {
            System.out.println("The generated key is - " + res);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            genKey(input);
        }
    }
}
