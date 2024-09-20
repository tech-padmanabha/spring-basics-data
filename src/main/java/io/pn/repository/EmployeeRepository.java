package io.pn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.pn.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> getByEmpName(String empName);

	List<Employee> readBySalaryGreaterThanEqual(BigDecimal salary);
	
	List<Employee> queryByJobIgnoreCase(String job);
	
	long countByJob(String job);
	
	void deleteByEmpName(String empName);
	
	boolean existsByEmpName(String empName);
	
	void removeBySalaryLessThanEqual(BigDecimal sal);
	
	List<Employee> streamByHireDateBetween(LocalDate start,LocalDate end);
	
	List<Employee> searchByEmpNameLikeAllIgnoreCase(String name);
	
	List<Employee> searchByJobAndHireDate(String job, LocalDate hireDate);
	
}

/**
 * we can use this kind of patterns to work with jpa
 * 
 * getBy, readBy, searchBy, streamBy, queryBy, removeBy, existsBy, deleteBy, countBy
 */