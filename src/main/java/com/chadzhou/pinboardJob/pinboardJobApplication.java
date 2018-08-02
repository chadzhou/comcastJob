package com.chadzhou.pinboardJob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class pinboardJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(pinboardJobApplication.class, args);
		System.out.println("Running app data: ");
	}
}
