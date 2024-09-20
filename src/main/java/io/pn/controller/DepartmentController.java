package io.pn.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pn.dto.DepartmentDto;
import io.pn.entity.Employee;
import io.pn.service.DepartmentServiceImpl;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl service;
	
	@GetMapping("/get-dept")
	public Set<DepartmentDto> getDepartment(){
		Set<DepartmentDto> sets = service.getDepartment();
		
		return sets;
	}
	
	
	@GetMapping("/get-emp")
	public List<Employee> getEmployee(){
		
		return null;
	}

}
