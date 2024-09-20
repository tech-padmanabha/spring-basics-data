package io.pn.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pn.dto.EmployeeDto;
import io.pn.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/get-all")
	public List<EmployeeDto> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@GetMapping("/get-by-name/{empName}")
	public List<EmployeeDto> searchEmployeesByName(@PathVariable String empName){
		return empService.getEmployeesByName(empName);
	}
	
	@GetMapping("/get-by-sal/{sal}")
	public List<EmployeeDto> searchEmployeesBySalaryGrater(@PathVariable BigDecimal sal){
		return empService.getEmployeesBySalaryRange(sal);
	}
	
	@GetMapping("/search-j-h")
	public List<EmployeeDto> searchByJobAndHireDate(@RequestParam String job,@RequestParam LocalDate hireDate){
		return empService.searchByJobAndHireDate(job, hireDate);
	}
	
	@GetMapping("/search-n")
	public List<EmployeeDto> searchByEmpNameLikeAllIgnoreCase(@RequestParam String name){
		
		return empService.searchByEmpNameLikeAllIgnoreCase(name);
	}
	
	@GetMapping("/search-s-e")
	public List<EmployeeDto> searchByHireDateBetween(@RequestParam LocalDate start,@RequestParam LocalDate end){
		
		return empService.streamByHireDateBetween(start, end);
	}
	
	@DeleteMapping("/remove-by-sal/{sal}")
	public String removeBySalaryLessThanEqual(@PathVariable BigDecimal sal) {
		
		empService.removeBySalaryLessThanEqual(sal);
		return "Success..";
	}
	
	@GetMapping("/exists/{empName}")
	public boolean existsByEmpName(@PathVariable String empName) {
		return empService.existsByEmpName(empName);
	}
	
	@DeleteMapping("/remove-by-name/{empName}")
	public String deleteByEmpName(@PathVariable String empName) {
		empService.deleteByEmpName(empName);
		return "Success...";
	}
	
	@GetMapping("/search-j")
	public List<EmployeeDto> searchByJobIgnoreCase(@RequestParam String job){
		return empService.queryByJobIgnoreCase(job);
	}
	@GetMapping("/count-j")
	public long countByJob(@RequestParam String job) {
		return empService.countByJob(job);
	}
	
	
}
