package io.pn.service;

import java.util.List;
import java.util.Set;

import io.pn.dto.DepartmentDto;

public interface DepartmentService {
	Set<DepartmentDto> getDepartment();
	List<DepartmentDto> searchByLocation(String location);
}
