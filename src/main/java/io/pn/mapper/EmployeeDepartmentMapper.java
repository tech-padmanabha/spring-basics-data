package io.pn.mapper;

import java.util.HashSet;
import java.util.Set;

import io.pn.dto.DepartmentDto;
import io.pn.dto.EmployeeDto;
import io.pn.entity.Department;
import io.pn.entity.Employee;

public class EmployeeDepartmentMapper {

	public static EmployeeDto convertToDtoEmployee(Employee x) {
		
		EmployeeDto empDto = new EmployeeDto(x.getEmpId(), 
				x.getEmpName(), x.getJob(), x.getManager(), 
				x.getHireDate(),x.getSalary(), x.getCommission(),x.getDepartment().getDepartmentNo());
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
	
	public static DepartmentDto convertToOnlyDtoDepartment(Department dept) {
		DepartmentDto dto = new DepartmentDto(dept.getDepartmentNo(), dept.getDepartmentName(), dept.getLocation(), null);
		return dto;
	}
	
	public static EmployeeDto convertToDtoEmployees(Employee x) {
				
		EmployeeDto empDto = new EmployeeDto(x.getEmpId(), 
				x.getEmpName(), x.getJob(), x.getManager(), 
				x.getHireDate(),x.getSalary(), x.getCommission(),
				x.getDepartment().getDepartmentNo()
				);
		return empDto;
	}

	public static Employee convertToEmployeeEntity(EmployeeDto dto){
		Employee emp = new Employee();

		emp.setEmpId(dto.empId());
		emp.setEmpName(dto.empName());
		emp.setCommission(dto.commission());
		emp.setManager(dto.manager());
		emp.setSalary(dto.salary());
		emp.setHireDate(dto.hireDate());
		emp.setJob(dto.job());

		return emp;
	}
	
}
