package io.pn.service;

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
public class DepartmentServiceImpl {
	
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
	
}