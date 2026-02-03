package csv_data_handling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {

    public static void main(String[] args) {
        String filePath = "C:\\BridgeLab-Training\\employee.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            writer.append("ID,Name,Department,Salary\n");

            writer.append("1,Tony Stark,IT,50000\n");
            writer.append("2,Natasha Romanoff,HR,45000\n");
            writer.append("3,Pepper Potts,Finance,55000\n");
            writer.append("4,Steve Rogers,Marketing,48000\n");
            writer.append("5,Bruce Banner,Sales,47000\n");

            System.out.println("Employee CSV file written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

