package io.pn.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pn.dto.EmployeeDto;
import io.pn.entity.Employee;
import io.pn.repository.EmployeeRepository;
import io.pn.util.DataUtils;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;

	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> empDto = new ArrayList<>();
		List<Employee> all = empRepo.findAll();

		all.forEach(emp -> empDto.add(DataUtils.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> getEmployeesByName(String name) {
		List<EmployeeDto> empDto = new ArrayList<>();
		List<Employee> byEmpName = empRepo.getByEmpName(name);
		byEmpName.forEach(emp -> empDto.add(DataUtils.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> getEmployeesBySalaryRange(BigDecimal salary) {
		List<EmployeeDto> empDto = new ArrayList<>();
		List<Employee> byEmpName = empRepo.readBySalaryGreaterThanEqual(salary);
		byEmpName.forEach(emp -> empDto.add(DataUtils.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> searchByJobAndHireDate(String job, LocalDate hireDate) {
		List<EmployeeDto> empDto = new ArrayList<>();
		var employees = empRepo.searchByJobAndHireDate(job, hireDate);
		employees.forEach(emp -> empDto.add(DataUtils.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> searchByEmpNameLikeAllIgnoreCase(String name) {
		List<EmployeeDto> empDto = new ArrayList<>();
		var employees = empRepo.searchByEmpNameLikeAllIgnoreCase(name);
		employees.forEach(emp -> empDto.add(DataUtils.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> streamByHireDateBetween(LocalDate start, LocalDate end) {
		List<EmployeeDto> empDto = new ArrayList<>();
		var employees = empRepo.streamByHireDateBetween(start, end);
		employees.forEach(emp -> empDto.add(DataUtils.convertToDtoEmployees(emp)));
		return empDto;
	}

	@Transactional
	public void removeBySalaryLessThanEqual(BigDecimal sal) {
		empRepo.removeBySalaryLessThanEqual(sal);
	}

	public boolean existsByEmpName(String empName) {
		return empRepo.existsByEmpName(empName);
	}

	@Transactional
	public void deleteByEmpName(String empName) {
		empRepo.deleteByEmpName(empName);
	}

	public List<EmployeeDto> queryByJobIgnoreCase(String job) {
		List<EmployeeDto> empDto = new ArrayList<>();
		var employees = empRepo.queryByJobIgnoreCase(job);
		employees.forEach(emp -> empDto.add(DataUtils.convertToDtoEmployees(emp)));
		return empDto;
	}

	public long countByJob(String job) {
		return empRepo.countByJob(job);
	}

	
}
