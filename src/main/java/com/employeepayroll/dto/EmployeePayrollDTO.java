package com.employeepayroll.dto;

/**
 * Data Transfer Object for Employee Payroll request data.
 * Simplistic design with name and salary fields initially.
 */
public class EmployeePayrollDTO {
    public String name;
    public long salary;

    // Parameterized constructor
    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
    
    // Default constructor
    public EmployeePayrollDTO() {}
}