package com.example.restcontrolleradvice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Application extends SpringServletContainerInitializer {

	public static void main(final String... args)
    {
		SpringApplication.run(Application.class, args);
	}
}