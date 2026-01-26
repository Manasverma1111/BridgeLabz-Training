package java_streams;
import java.io.*;

public class StudentData {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {

        writeStudentData(101, "Tony Stark", 8.7);
        writeStudentData(102, "Steve Rogers", 8.2);

        readStudentData();
    }

    // Store primitive data using DataOutputStream
    private static void writeStudentData(int rollNo, String name, double gpa) {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    // Retrieve primitive data using DataInputStream
    private static void readStudentData() {

        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {

            System.out.println("\nRetrieved Student Records:");

            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
