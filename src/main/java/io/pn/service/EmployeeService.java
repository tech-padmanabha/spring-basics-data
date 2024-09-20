package io.pn.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import io.pn.dto.EmployeeDto;

public interface EmployeeService {
	List<EmployeeDto> getAllEmployees();
	List<EmployeeDto> getEmployeesByName(String name);
	List<EmployeeDto> getEmployeesBySalaryRange(BigDecimal salary);
	List<EmployeeDto> searchByJobAndHireDate(String job, LocalDate hireDate);
	List<EmployeeDto> searchByEmpNameLikeAllIgnoreCase(String name);
	public List<EmployeeDto> streamByHireDateBetween(LocalDate start, LocalDate end);
	public void removeBySalaryLessThanEqual(BigDecimal sal);
	boolean existsByEmpName(String empName);
	void deleteByEmpName(String empName);
	List<EmployeeDto> queryByJobIgnoreCase(String job);
	long countByJob(String job);
}
