package com.example.stageWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class StageWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(StageWebApplication.class, args);
	}

}
