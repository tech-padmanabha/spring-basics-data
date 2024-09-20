package io.pn.dto;

import java.util.Set;

public record DepartmentDto(
		Integer departmentNo,
		String departmentName,
		String location,
		Set<EmployeeDto> employees
		){
}
