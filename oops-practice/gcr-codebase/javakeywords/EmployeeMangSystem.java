class Employeess {

    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;
    final int id;
    String name;
    String designation;

    // 2. Constructor using this
    Employeess(int id, String name, String designation) {

        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {

        System.out.println("Total Employees: " + totalEmployees);
    }

    // 4. instanceof check before displaying details
    void displayDetails(Object obj) {

        if (obj instanceof Employeess) {
            Employeess emp = (Employeess) obj;
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + emp.id);
            System.out.println();
            System.out.println("Name: " + emp.name);
            System.out.println("Designation: " + emp.designation);
        }
    }
}

public class EmployeeMangSystem {
    public static void main(String[] args) {

        Employeess emp1 = new Employeess(101, "Thamarai", "Software Engineer");
        Employeess emp2 = new Employeess(102, "Rohan", "Project Manager");

        Employeess.displayTotalEmployees();
        emp1.displayDetails(emp1);
        emp2.displayDetails(emp2);
    }
}
