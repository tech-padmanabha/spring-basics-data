package io.pn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
// It's enable support for Pagenation
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class SpringBasicsDataApplication{
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBasicsDataApplication.class, args);
	}

}
