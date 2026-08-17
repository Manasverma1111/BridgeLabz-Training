package org.example.employee_payroll_app.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.example.employee_payroll_app.dto.EmployeePayrollReqDTO;
import org.example.employee_payroll_app.dto.EmployeePayrollResDTO;
import org.example.employee_payroll_app.service.EmployeePayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeePayrollController {

    private final EmployeePayrollService service;

    // CREATE
    @PostMapping
    public ResponseEntity<EmployeePayrollResDTO> createEmployee(
            @Valid @RequestBody EmployeePayrollReqDTO request) {

        EmployeePayrollResDTO response =
                service.createEmployee(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<EmployeePayrollResDTO>> getAllEmployees() {

        return ResponseEntity.ok(
                service.getAllEmployees()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayrollResDTO> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getEmployeeById(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmployeePayrollResDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeePayrollReqDTO request) {

        return ResponseEntity.ok(
                service.updateEmployee(id, request)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable Long id) {

        service.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
}