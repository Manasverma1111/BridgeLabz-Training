package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {

    public static void main(String[] args) {
        String filePath = "largefile.csv";
        int batchSize = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                batchCount++;
                totalCount++;

                if (batchCount == batchSize) {
                    System.out.println("Processed records: " + totalCount);
                    batchCount = 0;
                }
            }

            System.out.println("Final record count: " + totalCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
