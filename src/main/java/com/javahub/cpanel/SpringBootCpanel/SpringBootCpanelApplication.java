package com.javahub.cpanel.SpringBootCpanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringBootCpanelApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootCpanelApplication.class);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCpanelApplication.class, args);
	}

}
