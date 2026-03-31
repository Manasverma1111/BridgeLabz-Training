package csv_data_handling;
import java.io.*;
import java.util.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SortRecordsCSV {

    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employees.add(new Employee(
                        data[0],
                        data[1],
                        Double.parseDouble(data[2])
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.println(e.name + " | " + e.department + " | " + e.salary);
        }
    }
}

