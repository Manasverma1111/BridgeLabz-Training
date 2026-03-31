package csv_data_handling;
import java.io.*;
import java.util.Base64;

public class EncryptNDecryptCSV {

    public static void main(String[] args) {

        String filePath = "secure_employees.csv";

        writeEncryptedCSV(filePath);
        readDecryptedCSV(filePath);
    }

    // Encryption
    private static String encrypt(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    // Decryption
    private static String decrypt(String encryptedValue) {
        return new String(Base64.getDecoder().decode(encryptedValue));
    }

    // write & encrypt CSV
    public static void writeEncryptedCSV(String filePath) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write("Name,Email,Salary");
            bw.newLine();

            bw.write("Tony," + encrypt("tony@gmail.com") + "," + encrypt("75000"));
            bw.newLine();

            bw.write("Natasha," + encrypt("natasha@yahoo.com") + "," + encrypt("82000"));
            bw.newLine();

            System.out.println("Encrypted CSV file written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read & decrypt CSV
    public static void readDecryptedCSV(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();
            String line;

            System.out.println("\nDecrypted Employee Data:");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                String email = decrypt(data[1]);
                String salary = decrypt(data[2]);

                System.out.println("Name: " + name + ", Email: " + email + ", Salary: " + salary);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
