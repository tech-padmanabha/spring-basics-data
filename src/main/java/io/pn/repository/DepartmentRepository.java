package io.pn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.pn.entity.Department;
import java.util.List;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	// we can use searBy
	List<Department> searchByLocation(String location);
	
}
