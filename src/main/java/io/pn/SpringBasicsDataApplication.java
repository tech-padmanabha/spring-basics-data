package io.pn;

import io.pn.repository.AadharCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
// It's enable support for Pagination
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class SpringBasicsDataApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringBasicsDataApplication.class, args);
	}

}
