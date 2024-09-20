package io.pn.util;

import java.util.HashSet;
import java.util.Set;

import io.pn.dto.DepartmentDto;
import io.pn.dto.EmployeeDto;
import io.pn.entity.Department;
import io.pn.entity.Employee;

public class DataUtils {

	public static EmployeeDto convertToDtoEmployee(Employee x) {
		
		EmployeeDto empDto = new EmployeeDto(x.getEmpId(), 
				x.getEmpName(), x.getJob(), x.getManager(), 
				x.getHireDate(),x.getSalary(), x.getCommission(),
				null);
		return empDto;
	}
	public static DepartmentDto convertToDtoDepartment(Department dept) {
		
		Set<EmployeeDto> empDto = new HashSet<>();
		Set<Employee> employees = dept.getEmployees();
		for(Employee x:employees) {
			empDto.add(convertToDtoEmployee(x));
		}
		DepartmentDto deptDto = new DepartmentDto(dept.getDepartmentNo(),
					dept.getDepartmentName(), dept.getLocation(), empDto);
		
		return deptDto;
	}
}
