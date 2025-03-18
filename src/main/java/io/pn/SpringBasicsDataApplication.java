package io.pn;

import io.pn.entity.Address;
import io.pn.entity.Student;
import io.pn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
// It's enable support for Pagination
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class SpringBasicsDataApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBasicsDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student stu = new Student();
		stu.setStudentName("Rajesh Sharma");

		Address ca = new Address();
		ca.setDist("Ganjam");
		ca.setState("Odisha");
		ca.setZip("761110");
		ca.setAddLine("Near R Kulya river");

		Address pa = new Address();
		pa.setDist("Kormangala");
		pa.setState("Karnataka");
		pa.setZip("763010");
		pa.setAddLine("Near Wipro Office");

		stu.setCurrentAddress(ca);
		stu.setBillingAddress(pa);

		var sub = stu.getSubjectPrice();
		sub.put("Java",3034.30);
		sub.put("JavaScript",3050.30);
		sub.put("Spring",4034.30);
		studentRepository.save(stu);
	}
}
