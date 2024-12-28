package io.pn.service.impls;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import io.pn.entity.Department;
import io.pn.exception.ResourceNotFoundException;
import io.pn.repository.DepartmentRepository;
import io.pn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.pn.dto.EmployeeDto;
import io.pn.entity.Employee;
import io.pn.repository.EmployeeRepository;
import io.pn.mapper.EmployeeDepartmentMapper;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private DepartmentRepository departmentRepository;

	public Page<EmployeeDto> getAllEmployeeByPagination(int pageSize,int pageNumber,String sortBy){
		Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNumber);
		Sort sort = Sort.by(Sort.Order.desc(sortBy));
		pageable.getSortOr(sort);
		Page<Employee> empPage = empRepo.findAll(pageable);
		if(empPage.isEmpty()){
			throw new ResourceNotFoundException("Employee Page Data not Available");
		}
		Page<EmployeeDto> empPageDto = empPage.map(new Function<Employee, EmployeeDto>() {
			@Override
			public EmployeeDto apply(Employee employee) {
				return EmployeeDepartmentMapper.convertToDtoEmployee(employee);
			}
		});
		return empPageDto;
	}

	public EmployeeDto saveEmployee(EmployeeDto employeeDto){
		Department department =  departmentRepository.findById(employeeDto.deptNo())
				.orElseThrow(()->  new ResourceNotFoundException("Department not available"));
		Employee emp = EmployeeDepartmentMapper.convertToEmployeeEntity(employeeDto);
		emp.setDepartment(department);
		Employee savedEmp  = empRepo.save(emp);
		return EmployeeDepartmentMapper.convertToDtoEmployee(savedEmp);
	}

	public EmployeeDto getEmployeeById(Integer empNo){
		Employee empData = empRepo.getByEmpId(empNo)
				.orElseThrow(() ->new ResourceNotFoundException("Employee Number doesn't exists of:"+empNo));
		EmployeeDto empRep = EmployeeDepartmentMapper.convertToDtoEmployee(empData);
		return empRep;
	}

	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> empDto = new ArrayList<>();
		List<Employee> all = empRepo.findAll();

		all.forEach(emp -> empDto.add(EmployeeDepartmentMapper.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> getEmployeesByName(String name) {
		List<EmployeeDto> empDto = new ArrayList<>();
		List<Employee> byEmpName = empRepo.getByEmpName(name);
		byEmpName.forEach(emp -> empDto.add(EmployeeDepartmentMapper.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> getEmployeesBySalaryRange(BigDecimal salary) {
		List<EmployeeDto> empDto = new ArrayList<>();
		List<Employee> byEmpName = empRepo.readBySalaryGreaterThanEqual(salary);
		byEmpName.forEach(emp -> empDto.add(EmployeeDepartmentMapper.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> searchByJobAndHireDate(String job, LocalDate hireDate) {
		List<EmployeeDto> empDto = new ArrayList<>();
		var employees = empRepo.searchByJobAndHireDate(job, hireDate);
		employees.forEach(emp -> empDto.add(EmployeeDepartmentMapper.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> searchByEmpNameLikeAllIgnoreCase(String name) {
		List<EmployeeDto> empDto = new ArrayList<>();
		var employees = empRepo.searchByEmpNameLikeAllIgnoreCase(name);
		employees.forEach(emp -> empDto.add(EmployeeDepartmentMapper.convertToDtoEmployees(emp)));
		return empDto;
	}

	public List<EmployeeDto> streamByHireDateBetween(LocalDate start, LocalDate end) {
		List<EmployeeDto> empDto = new ArrayList<>();
		var employees = empRepo.streamByHireDateBetween(start, end);
		employees.forEach(emp -> empDto.add(EmployeeDepartmentMapper.convertToDtoEmployees(emp)));
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
		employees.forEach(emp -> empDto.add(EmployeeDepartmentMapper.convertToDtoEmployees(emp)));
		return empDto;
	}

	public long countByJob(String job) {
		return empRepo.countByJob(job);
	}

	
}
