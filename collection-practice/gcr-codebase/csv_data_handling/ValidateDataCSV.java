package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateDataCSV {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{10}");

    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int rowNumber = 1;

            while ((line = br.readLine()) != null) {
                rowNumber++;
                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];

                boolean valid = true;

                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println("Invalid Email at row " + rowNumber + ": " + line);
                    valid = false;
                }

                if (!PHONE_PATTERN.matcher(phone).matches()) {
                    System.out.println("Invalid Phone at row " + rowNumber + ": " + line);
                    valid = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

