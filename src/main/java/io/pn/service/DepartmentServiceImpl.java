package io.pn.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pn.dto.DepartmentDto;
import io.pn.entity.Department;
import io.pn.repository.DepartmentRepository;
import io.pn.util.DataUtils;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository deptRepo;

	
	public Set<DepartmentDto> getDepartment(){		
		List<Department> all = deptRepo.findAll();
		Set<DepartmentDto> deptDto = new HashSet<>();	
		for(Department dept: all) {
			deptDto.add(DataUtils.convertToDtoDepartment(dept));
		}		
		
		return deptDto;
	}

	public List<DepartmentDto> searchByLocation(String location){
		List<Department> department = deptRepo.searchByLocation(location);
		List<DepartmentDto> deptDto = new ArrayList<>();
		department.forEach(dept -> deptDto.add(DataUtils.convertToDtoDepartment(dept)));
		return deptDto;
	}
}