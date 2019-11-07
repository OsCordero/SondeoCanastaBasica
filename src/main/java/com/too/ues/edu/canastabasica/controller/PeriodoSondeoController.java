package com.too.ues.edu.canastabasica.controller;

import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.repo.PeriodoSondeoRepo;
import com.too.ues.edu.canastabasica.servicio.PeriodoSondeoService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * PeriodoSondeoController
 */
@Controller
public class PeriodoSondeoController {
	
    private Session session;
    private DataSourceFactory dataSourceFactory;

	@Autowired
	@Qualifier("periodoSondeoImpl")
	private PeriodoSondeoService periodoSondeoService;

	@Autowired
	private PeriodoSondeoRepo repo;


    // Vista que muestra el formulario para registrar usuario
	@GetMapping("/registrarperiodo")
	public ModelAndView createPeriodoSondeo() {
		ModelAndView mav = new ModelAndView("registrarperiodo");
		mav.addObject("periodo", new PeriodoSondeo());
		return mav;
    }
    
    @GetMapping("/addperiodo")
	public @ResponseBody String addPeriodo(@ModelAttribute("periodo") PeriodoSondeo periodo) {
		
		periodo.setFinalizado(true);		
	
		periodoSondeoService.addPeriodoSondeo(periodo);
			
		return "registrado con exito";
	}
    
}