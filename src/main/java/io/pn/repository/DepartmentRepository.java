package io.pn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.pn.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query("SELECT t FROM Department t JOIN FETCH t.employees" )
	List<Department> readAllDeparment();
}
