package com.employeepayroll.exception;

/**
 * Custom exception class for handling domain-specific Employee Payroll errors.
 */
public class EmployeePayrollException extends RuntimeException {
    // Constructor injecting the error message to the superclass
    public EmployeePayrollException(String message) {
        super(message);
    }
}