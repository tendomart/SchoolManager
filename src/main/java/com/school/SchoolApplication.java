package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SchoolApplication {

	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SchoolApplication.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

}
