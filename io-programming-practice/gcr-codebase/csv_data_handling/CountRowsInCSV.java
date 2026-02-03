package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsInCSV {

    public static void main(String[] args) {
        String filePath = "C:\\BridgeLab-Training\\students.csv";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while (br.readLine() != null) {
                count++;
            }

            System.out.println("Total Records (excluding header): " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
