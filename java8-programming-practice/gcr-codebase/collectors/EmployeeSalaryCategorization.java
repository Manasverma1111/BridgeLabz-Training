package collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employees {

    String name;

    String dept;
    double salary;

    public Employees(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    String getName() {
        return name;
    }
    String getDept() {
        return dept;
    }

    double getSalary() {
        return salary;
    }
}
public class EmployeeSalaryCategorization {

    public static void main(String[] args) {

        List<Employees> employeesList = List.of(
                new Employees("Bruce", "IT", 48570.88),
                new Employees("Gamora","Sales", 36888.25),
                new Employees("Bob", "IT", 51537.00),
                new Employees("Tony", "Marketing", 41312.50),
                new Employees("Jhon", "Sales", 42635.58)
        );

        Map<String, Double> avgSalary = employeesList.stream().collect(Collectors.groupingBy(Employees::getDept, Collectors.averagingDouble(Employees::getSalary)));
        System.out.println(avgSalary);
    }
}
