package org.springboot.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "org.springboot")
@ComponentScan(basePackages = "org.springboot")
public class SpringStudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
	}

}
