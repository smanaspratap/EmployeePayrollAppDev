package com.employeepayroll.service;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class handling the core business logic.
 * Stores Employee Payroll Data in an in-memory List.
 */
@Service
public class EmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    // Fetch all employees
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    // Fetch employee by ID
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(empData -> empData.getEmployeeId() == empId)
                .findFirst()
                .orElse(null);
    }

    // Create a new employee entry
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(employeePayrollList.size() + 1, empPayrollDTO);
        employeePayrollList.add(empData);
        return empData;
    }

    // Update an existing employee entry
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        if (empData != null) {
            empData.setName(empPayrollDTO.name);
            empData.setSalary(empPayrollDTO.salary);
        }
        return empData;
    }

    // Delete an employee entry
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.removeIf(empData -> empData.getEmployeeId() == empId);
    }
}