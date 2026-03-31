class Employees {

    public int employeeID;
    protected String department;
    private double salary;

    Employees(int employeeID, String department, double salary) {

        this.employeeID = employeeID;
        this.department = department;
        setSalary(salary);
    }

    // Public getter for salary
    public double getSalary() {
        return salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {

        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount");
        }
    }

    // Display basic employee details
    void displayEmployeeDetails() {

        System.out.println("Employee ID : " + employeeID);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : ₹" + salary);
    }
}

// Child class
class Manager extends Employees {

    String role;

    // Constructor
    Manager(int employeeID, String department, double salary, String role) {
        super(employeeID, department, salary);
        this.role = role;
    }

    // Method demonstrating access to public and protected members
    void displayManagerDetails() {

        System.out.println("Manager Details");
        System.out.println("Employee ID : " + employeeID);   // public access
        System.out.println("Department  : " + department);   // protected access
        System.out.println("Role        : " + role);
        System.out.println("Salary      : ₹" + getSalary()); // private via getter
    }
}

// Main class
public class EmployeeRecords {

    public static void main(String[] args) {

        Manager manager = new Manager(1001, "IT", 75000, "Project Manager");

        manager.displayEmployeeDetails();
        System.out.println();
//        modify salary using public method
        manager.setSalary(85000);
        manager.displayManagerDetails();
    }
}
