package io.pn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import io.pn.entity.Courses;
import io.pn.entity.Teachers;
import io.pn.repository.TeacherRepository;


@SpringBootTest
@DataJpaTest
public class TeacherTest {
	
	
	@Autowired
	TeacherRepository teacherRepo;
	
	@Test
	public void test() {
		
		Teachers tea = new Teachers();
		List<Courses> courseList = new ArrayList<>();
		
		Courses course = new Courses();
		course.setSubject("Java");
		course.setTimings(List.of(LocalTime.now(),LocalTime.NOON));
		
		courseList.add(course);
		
		Courses course2 = new Courses();
		course.setSubject("AdvancedJava");
		course.setTimings(List.of(LocalTime.now(),LocalTime.NOON));
		
		courseList.add(course2);
		
		tea.setName("HK");
		tea.setFee(2000d);
		tea.setCourses(courseList);
		Teachers save = teacherRepo.save(tea);
		
		assertNotNull(teacherRepo.findAll());
	}
	

}
