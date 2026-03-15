package m1_practice;

import java.util.Scanner;

public class CorporateEmailValidation {

    public static String validation(String input) {

        String regex = "[a-z]{3,}.[a-z]{3,}[0-9]{4,}@(sales|IT|product).(company).(com)";
        if (input.matches(regex)) {
            return "ACCESS GRANTED";
        } else{
            return "ACCESS DENIED";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            String res = validation(input);
            System.out.println(res);
        }

    }
}
