package com.employeepayroll.controller;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.dto.ResponseDTO;
import com.employeepayroll.model.EmployeePayrollData;
import com.employeepayroll.service.EmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing Employee Payroll API endpoints.
 * Integrates closely with the service layer and uses standard ResponseDTOs.
 */
@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    // Handles GET request to fetch all contacts
    @GetMapping(value = {"", "/"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        log.info("Controller: Calling GET All Employees API");
        List<EmployeePayrollData> empDataList = service.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", empDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Handles GET request to fetch an employee by ID
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable int empId) {
        log.info("Controller: Calling GET Employee By ID API for ID: {}", empId);
        EmployeePayrollData empData = service.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Handles POST request with standard @Valid annotation to enforce validation
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        log.info("Controller: Calling POST Add Employee API");
        EmployeePayrollData empData = service.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Handles PUT request with standard @Valid annotation to enforce validation
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int empId, @Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        log.info("Controller: Calling PUT Update Employee API for ID: {}", empId);
        EmployeePayrollData empData = service.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Handles DELETE request
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int empId) {
        log.info("Controller: Calling DELETE Employee API for ID: {}", empId);
        service.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted ID: " + empId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}