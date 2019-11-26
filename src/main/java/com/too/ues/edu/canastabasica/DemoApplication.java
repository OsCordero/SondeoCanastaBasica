package com.too.ues.edu.canastabasica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class DemoApplication {		

	public static void main(String[] args) {
				
		SpringApplication.run(DemoApplication.class, args);		
	}	

	@GetMapping("/error")
		public ModelAndView errorPage() {
			ModelAndView mav = new ModelAndView("error");			
			return mav;
		}
}
