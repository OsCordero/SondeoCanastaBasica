package com.too.ues.edu.canastabasica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping(value="/hello")
	public String getMethodName() {
		return "Hola Mundo";
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);		
	}	
}
