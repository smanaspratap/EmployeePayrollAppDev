package com.employeepayroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Data Transfer Object for carrying Employee Payroll request data.
 * Includes validation logic to enforce data integrity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
    
    @NotEmpty(message = "Employee name cannot be null or empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name is Invalid. It must start with a capital letter and have at least 3 characters.")
    public String name;

    @Min(value = 500, message = "Minimum wage should be more than 500")
    public long salary;
}