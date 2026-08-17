package org.example.employee_payroll_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePayrollReqDTO {

    @NotBlank(message = "Emplyee name is required")
    private String empName;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Department is required")
    private String dept;

    @NotNull(message = "Basic Salary is required")
    private BigDecimal basicSalary;

    @NotNull(message = "Allowances is required")
    private BigDecimal allowances;

    @NotNull(message = "Deductions are required")
    private BigDecimal deductions;

}
