package com.employeepayroll.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Data Transfer Object for carrying Employee Payroll request data.
 * Utilizes Lombok @Data to autogenerate getters and setters.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
    public String name;
    public long salary;
}