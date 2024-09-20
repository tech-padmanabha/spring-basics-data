package io.pn.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pn.dto.DepartmentDto;
import io.pn.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl service;
	
	@GetMapping("/get-all")
	public Set<DepartmentDto> getDepartment(){
		Set<DepartmentDto> sets = service.getDepartment();
		
		return sets;
	}
	
	@GetMapping("/get-by-location/{location}")
	public List<DepartmentDto> searchByLocation(@PathVariable String location){
		List<DepartmentDto> searchByLocation = service.searchByLocation(location);
		return searchByLocation;
	}
}
