package io.pn.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeDto(Integer empId,
        String empName,
        String job,
        Integer manager,
        LocalDate hireDate,
        BigDecimal salary,
        BigDecimal commission,
        DepartmentDto department
        ) {}
