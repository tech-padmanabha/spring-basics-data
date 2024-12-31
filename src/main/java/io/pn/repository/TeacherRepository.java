package io.pn.repository;

import io.pn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.pn.entity.Teachers;



@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Long> {


}
