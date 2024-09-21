package io.pn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.pn.entity.Teachers;



@Repository
public interface TeacherRepository extends CrudRepository<Teachers, Long>{
	
	
}
