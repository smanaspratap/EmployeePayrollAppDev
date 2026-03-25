package com.employeepayroll.service;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class handling the core business logic.
 * Utilizes Lombok @Slf4j for logging.
 */
@Slf4j
@Service
public class EmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    // Fetch all employees
    public List<EmployeePayrollData> getEmployeePayrollData() {
        log.info("Fetching all employee payroll records.");
        return employeePayrollList;
    }

    // Fetch employee by ID
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        log.info("Fetching employee with ID: {}", empId);
        return employeePayrollList.stream()
                .filter(empData -> empData.getEmployeeId() == empId)
                .findFirst()
                .orElse(null);
    }

    // Create a new employee entry
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        log.info("Creating new employee with name: {}", empPayrollDTO.name);
        EmployeePayrollData empData = new EmployeePayrollData(employeePayrollList.size() + 1, empPayrollDTO);
        employeePayrollList.add(empData);
        return empData;
    }

    // Update an existing employee entry
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        log.info("Updating employee with ID: {}", empId);
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        if (empData != null) {
            empData.setName(empPayrollDTO.name);
            empData.setSalary(empPayrollDTO.salary);
        }
        return empData;
    }

    // Delete an employee entry
    public void deleteEmployeePayrollData(int empId) {
        log.info("Deleting employee with ID: {}", empId);
        employeePayrollList.removeIf(empData -> empData.getEmployeeId() == empId);
    }
}