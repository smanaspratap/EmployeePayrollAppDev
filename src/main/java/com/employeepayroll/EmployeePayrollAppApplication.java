package com.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Employee Payroll Application.
 * Initializes the Spring Boot context.
 */
@SpringBootApplication
public class EmployeePayrollAppApplication {
    
    // Main method to run the Spring Boot app
    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollAppApplication.class, args);
    }
}