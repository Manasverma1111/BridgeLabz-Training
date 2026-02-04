package functional_interfaces;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {

    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class DateFormatUtility {

    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        System.out.println("Invoice Date (dd-MM-yyyy): " + DateUtils.formatDate(invoiceDate, "dd-MM-yyyy"));
        System.out.println("Invoice Date (yyyy/MM/dd): " + DateUtils.formatDate(invoiceDate, "yyyy/MM/dd"));
        System.out.println("Invoice Date (MMM dd, yyyy): " + DateUtils.formatDate(invoiceDate, "MMM dd, yyyy"));
    }
}
