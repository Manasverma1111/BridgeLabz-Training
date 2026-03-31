package csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudentsCSV {

    public static void main(String[] args) {
        String filePath = "C:\\BridgeLab-Training\\students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("Student ID   : " + data[0]);
                System.out.println("Name         : " + data[1]);
                System.out.println("Age          : " + data[2]);
                System.out.println("Marks        : " + data[3]);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
