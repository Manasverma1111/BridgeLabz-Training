package csv_data_handling;
import java.io.*;

public class ModifyFileCSV {

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String department = data[1];
                double salary = Double.parseDouble(data[2]);

                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }

                bw.write(data[0] + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("Updated CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
