package com.employeepayroll.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for testing basic connectivity.
 * Implements GET, POST, PUT, DELETE mappings.
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // Handles basic GET request
    @GetMapping(value = {"", "/"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<>("Get Call Success", HttpStatus.OK);
    }

    // Handles GET request by ID
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable int empId) {
        return new ResponseEntity<>("Get Call Success for id: " + empId, HttpStatus.OK);
    }

    // Handles POST request
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody String employeeDTO) {
        return new ResponseEntity<>("Created Employee Payroll Data: " + employeeDTO, HttpStatus.CREATED);
    }

    // Handles PUT request
    @PutMapping("/update/{empId}")
    public ResponseEntity<String> updateEmployeePayrollData(@PathVariable int empId, @RequestBody String employeeDTO) {
        return new ResponseEntity<>("Updated Employee Payroll Data for id: " + empId, HttpStatus.OK);
    }

    // Handles DELETE request
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
        return new ResponseEntity<>("Deleted Employee Payroll Data for id: " + empId, HttpStatus.OK);
    }
}