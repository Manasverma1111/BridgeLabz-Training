class Employee {

    String name;
    int id;
    double salary;
//    method to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name = "Rohan";
        emp.id = 1;
        emp.salary = 500000;
        emp.displayDetails();
    }
}
