package io.pn.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeDto(
        Integer empId,
        @NotNull(message = "Employee Name should not be Null")
        String empName,
        @NotNull(message = "Job should not be null")
        String job,
        @NotNull(message = "Manager Should not be null")
        @Digits(integer = 0,fraction = 9999, message = "Provide the Digits")
        Integer manager,
        LocalDate hireDate,
        BigDecimal salary,
        BigDecimal commission,
        Integer deptNo
       // DepartmentDto department
        ) {}
