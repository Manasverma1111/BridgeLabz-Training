import java.util.ArrayList;
import java.util.List;

class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {
//    process the invoice input and returns list of amounts
    public static List<Integer> parseInvoice(String input) throws InvalidInvoiceFormatException {

        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input cannot be empty");
        }

        String[] items = input.split(",");
        List<Integer> amounts = new ArrayList<>();

        for (String item : items) {
            item = item.trim();

            if (!item.contains("-")) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format: Missing '-' in \"" + item + "\""
                );
            }

            String[] parts = item.split("-");

            if (parts.length != 2) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format near \"" + item + "\""
                );
            }

            String taskName = parts[0].trim();
            String amountPart = parts[1].trim();
//            get numeric amount (before INR)
            String[] amountTokens = amountPart.split(" ");

            if (amountTokens.length == 0) {
                throw new InvalidInvoiceFormatException(
                        "Missing amount for task: " + taskName
                );
            }

            try {
                int amount = Integer.parseInt(amountTokens[0]);
                amounts.add(amount);
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException(
                        "Invalid amount for task: " + taskName
                );
            }
        }

        return amounts;
    }

    public static int getTotalAmount(List<Integer> amounts) {

        int total = 0;
        for (int amount : amounts) {
            total += amount;
        }
        return total;
    }

    public static void main(String[] args) {

        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        try {
            List<Integer> amounts = parseInvoice(input);
            int total = getTotalAmount(amounts);

            System.out.println("Invoice Details:");
            System.out.println("Input: " + input);
            System.out.println("Total Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
