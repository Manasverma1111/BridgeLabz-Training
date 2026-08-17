package org.example.employee_payroll_app.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id) {
        super("Employee with ID: " + id + " not found");
    }
}
