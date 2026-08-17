package org.example.employee_payroll_app.repository;

import org.example.employee_payroll_app.entity.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long> {

    boolean existsByEmail(String email);

}
