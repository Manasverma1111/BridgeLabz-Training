package regex;
public class LicensePlateValidation {

    public static boolean isValid(String plate) {
        return plate != null && plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {

        String plate1 = "AB1234";
        String plate2 = "A1234";
        System.out.println(isValid(plate1));
        System.out.println(isValid(plate2));
    }
}

