package com.employeepayroll.model;

import com.employeepayroll.dto.EmployeePayrollDTO;

/**
 * Domain model representing an Employee Payroll entry.
 */
public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    // Default constructor
    public EmployeePayrollData() {}

    // Constructor generating Model from DTO
    public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        this.employeeId = empId;
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
    }

    // Getter for employeeId
    public int getEmployeeId() { return employeeId; }
    
    // Setter for employeeId
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    
    // Getter for name
    public String getName() { return name; }
    
    // Setter for name
    public void setName(String name) { this.name = name; }
    
    // Getter for salary
    public long getSalary() { return salary; }
    
    // Setter for salary
    public void setSalary(long salary) { this.salary = salary; }
}