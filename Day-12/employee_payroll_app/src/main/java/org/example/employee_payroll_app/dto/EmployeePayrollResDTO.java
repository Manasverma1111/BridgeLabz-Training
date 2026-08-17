package org.example.employee_payroll_app.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePayrollResDTO {

    private Long id;
    private String empName;
    private String email;
    private String dept;
    private BigDecimal basicSalary;
    private BigDecimal allowances;
    private BigDecimal deduction;
    private BigDecimal netSalary;
}
