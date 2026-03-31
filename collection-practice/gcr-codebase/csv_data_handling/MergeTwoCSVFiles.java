package csv_data_handling;
import java.io.*;
import java.util.*;

public class MergeTwoCSVFiles {

    public static void main(String[] args) {
        Map<String, String> studentMap = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"))) {
            br1.readLine();
            String line;

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], data[1] + "," + data[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("merged_students.csv"))
        ) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            br2.readLine();
            String line;

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                if (studentMap.containsKey(data[0])) {
                    bw.write(data[0] + "," + studentMap.get(data[0]) + "," + data[1] + "," + data[2]);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
