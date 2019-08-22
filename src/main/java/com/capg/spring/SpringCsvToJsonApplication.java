package com.capg.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chilaksh
 * 
 * SpringBootApplication annotation is used to mark a configuration class that declares one or more 
 * 
 * @Bean methods and also triggers auto-configuration and component scanning. 
 * 
 */
@SpringBootApplication
public class SpringCsvToJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCsvToJsonApplication.class, args);
	}

}
