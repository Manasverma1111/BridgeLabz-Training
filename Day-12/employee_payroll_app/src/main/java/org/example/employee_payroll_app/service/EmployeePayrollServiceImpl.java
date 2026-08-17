package org.example.employee_payroll_app.service;

import lombok.RequiredArgsConstructor;
import org.example.employee_payroll_app.dto.EmployeePayrollReqDTO;
import org.example.employee_payroll_app.dto.EmployeePayrollResDTO;
import org.example.employee_payroll_app.entity.EmployeePayroll;
import org.example.employee_payroll_app.exception.EmployeeNotFoundException;
import org.example.employee_payroll_app.repository.EmployeePayrollRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    private final EmployeePayrollRepository repo;

    @Override
    public EmployeePayrollResDTO createEmployee(EmployeePayrollReqDTO req) {
        EmployeePayroll employee = EmployeePayroll.builder()
                .empName(req.getEmpName())
                .email(req.getEmail())
                .dept(req.getDept())
                .basicSalary(req.getBasicSalary())
                .allowances(req.getAllowances())
                .deduction(req.getDeductions())
                .netSalary(calculateNetSalary(req))
                .build();

        EmployeePayroll savedEmployee = repo.save(employee);

        return mapToResponse(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeePayrollResDTO getEmployeeById(Long id) {

        EmployeePayroll employee = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return mapToResponse(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeePayrollResDTO> getAllEmployees() {

        return repo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EmployeePayrollResDTO updateEmployee(
            Long id,
            EmployeePayrollReqDTO request) {

        EmployeePayroll employee = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employee.setEmpName(request.getEmpName());
        employee.setEmail(request.getEmail());
        employee.setDept(request.getDept());
        employee.setBasicSalary(request.getBasicSalary());
        employee.setAllowances(request.getAllowances());
        employee.setDeduction(request.getDeductions());

        employee.setNetSalary(calculateNetSalary(request));

        return mapToResponse(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        EmployeePayroll employee = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        repo.delete(employee);
    }

    private BigDecimal calculateNetSalary(
            EmployeePayrollReqDTO request) {

        return request.getBasicSalary()
                .add(request.getAllowances())
                .subtract(request.getDeductions());
    }

    private EmployeePayrollResDTO mapToResponse(
            EmployeePayroll employee) {

        return EmployeePayrollResDTO.builder()
                .id(employee.getId())
                .empName(employee.getEmpName())
                .email(employee.getEmail())
                .dept(employee.getDept())
                .basicSalary(employee.getBasicSalary())
                .allowances(employee.getAllowances())
                .deduction(employee.getDeduction())
                .netSalary(employee.getNetSalary())
                .build();
    }
}
