import java.util.ArrayList;
import java.util.List;

interface Department {
    void assignDepartment(String deptName);
    String getDeptDetails();
}

abstract class Empl implements Department {

    private int empId;
    private String name;
    private double baseSalary;
    private String department;

    public Empl(int empId, String name, double baseSalary) {
        this.empId = empId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calcSalary();

    public void displayDetails() {
        System.out.println("Empoyee ID: " + empId);
        System.out.println("Employee name: " + name);
        System.out.println("Base Salary: " + calcSalary());
        System.out.println("Department: " + department);
    }

    protected double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String getDeptDetails() {
        return department;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }
}

class FullTimeEmpl extends Empl {

    private double bonus;

    public FullTimeEmpl(int empId, String name, double baseSalary, double bonus) {
        super(empId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calcSalary() {
        return getBaseSalary() + bonus;
    }

}

class PartTimeEmpl extends Empl {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmpl(int empId, String name, int hoursWorked, double hourlyRate) {
        super(empId, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeeManagSys {
    public static void main(String[] args) {

        List<Empl> employees = new ArrayList<>();

        Empl emp1 = new FullTimeEmpl(101, "Alice", 50000, 10000);
        Empl emp2 = new PartTimeEmpl(102, "Bob", 80, 500);

        emp1.assignDepartment("Engineering");
        emp2.assignDepartment("Support");

        employees.add(emp1);
        employees.add(emp2);

        for (Empl emp : employees) {
            emp.displayDetails();
        }
    }
}
