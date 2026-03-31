// Unified Employee Management System Program

class Emp {
    protected String name;
    protected int id;
    protected double salary;

    Emp(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

// Manager subclass
class Managerr extends Emp {
    private int teamSize;

    Managerr(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {

        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Emp {
    private String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {

        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Emp {
    private int duration;

    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    void displayDetails() {

        super.displayDetails();
        System.out.println("Role: Intern");
        System.out.println("Duration: " + duration + " months");
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {

        Emp manager = new Managerr("Jack", 101, 90000, 10);
        Emp developer = new Developer("Natasha", 102, 70000, "Java");
        Emp intern = new Intern("Steve", 103, 15000, 6);

        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();

        intern.displayDetails();
    }
}
