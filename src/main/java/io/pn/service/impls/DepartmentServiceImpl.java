package io.pn.service.impls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.pn.exception.ResourceNotFoundException;
import io.pn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pn.dto.DepartmentDto;
import io.pn.entity.Department;
import io.pn.repository.DepartmentRepository;
import io.pn.mapper.EmployeeDepartmentMapper;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository deptRepo;

	
	public Set<DepartmentDto> getDepartment(){		
		List<Department> all = deptRepo.findAll();
		Set<DepartmentDto> deptDto = new HashSet<>();
		if(all.isEmpty()){
			throw new ResourceNotFoundException("Department not available");
		}
		for(Department dept: all) {
			deptDto.add(EmployeeDepartmentMapper.convertToDtoDepartment(dept));
		}

		return deptDto;
	}

	public List<DepartmentDto> searchByLocation(String location){
		List<Department> department = deptRepo.searchByLocation(location);
		List<DepartmentDto> deptDto = new ArrayList<>();
		department.forEach(dept -> deptDto.add(EmployeeDepartmentMapper.convertToDtoDepartment(dept)));
		return deptDto;
	}
}