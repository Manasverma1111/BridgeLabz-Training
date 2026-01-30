package regex;

public class CreditCardNumberValidation {

    public static boolean isValidCard(String cardNumber) {

        return cardNumber.matches("^(4\\d{15}|5\\d{15})$");
    }

    public static void main(String[] args) {

        String visaCardNumber = "4567123456783456";
        String masterCardNumber = "5123456789123456";

        System.out.println(isValidCard(visaCardNumber));
        System.out.println(isValidCard(masterCardNumber));
    }
}
