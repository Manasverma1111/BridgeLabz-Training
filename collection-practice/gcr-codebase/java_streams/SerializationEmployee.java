package java_streams;
import java.io.*;
import java.util.*;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee {" + "ID=" + id + ", Name='" + name + '\'' + ", Department='" + department + '\'' + ", Salary=" + salary + '}';
    }
}

public class SerializationEmployee {

    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Steve", "IT", 75000));
        employees.add(new Employee(102, "Natasha", "HR", 55000));
        employees.add(new Employee(103, "Jack", "Finance", 65000));

        serializeEmployees(employees);
        deserializeEmployees();
    }

    // Serialize employee list
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(employees);
            System.out.println("successfully serialized.");

        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Deserialize employee list
    private static void deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employee Data:");
            employees.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("IO Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
