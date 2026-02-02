package csv_data_handling;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

public class GenerateDBToCSV {

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        String csvFile = "employees_report.csv";
        String query = "SELECT id, name, department, salary FROM employees";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))
        ) {
            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            while (rs.next()) {
                bw.write(
                        rs.getInt("id") + "," +
                                rs.getString("name") + "," +
                                rs.getString("department") + "," +
                                rs.getDouble("salary")
                );
                bw.newLine();
            }

            System.out.println("CSV report generated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
