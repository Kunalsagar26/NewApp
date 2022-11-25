package com.javahub.cpanel.SpringBootCpanel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
class SpringBootCpanelApplicationTests extends SpringBootServletInitializer{

	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootCpanelApplicationTests.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCpanelApplicationTests.class, args);
	}
	
	
}
