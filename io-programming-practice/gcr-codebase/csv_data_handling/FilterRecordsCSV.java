package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsCSV {

    public static void main(String[] args) {
        String filePath = "C:\\BridgeLab-Training\\students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println(data[0] + " | " + data[1] + " | " + data[3]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

