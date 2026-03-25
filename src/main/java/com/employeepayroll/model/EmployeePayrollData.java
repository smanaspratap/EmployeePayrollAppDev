package com.employeepayroll.model;

import com.employeepayroll.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain model representing an Employee Payroll entry.
 * Utilizes Lombok @Data for boilerplate reduction.
 */
@Data
@NoArgsConstructor
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    // Constructor generating Model from DTO
    public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        this.employeeId = empId;
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
    }
}