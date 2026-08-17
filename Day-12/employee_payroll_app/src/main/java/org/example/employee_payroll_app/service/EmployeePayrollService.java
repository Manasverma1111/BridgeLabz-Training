package org.example.employee_payroll_app.service;

import org.example.employee_payroll_app.dto.EmployeePayrollReqDTO;
import org.example.employee_payroll_app.dto.EmployeePayrollResDTO;

import java.util.List;

public interface EmployeePayrollService {

    EmployeePayrollResDTO createEmployee(EmployeePayrollReqDTO req);

    EmployeePayrollResDTO getEmployeeById(Long id);

    List<EmployeePayrollResDTO> getAllEmployees();

    EmployeePayrollResDTO updateEmployee(Long id, EmployeePayrollReqDTO req);

    void deleteEmployee(Long id);
}
