package com.too.ues.edu.canastabasica.controller;

import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.repo.PeriodoSondeoRepo;
import com.too.ues.edu.canastabasica.servicio.PeriodoSondeoService;
import com.too.ues.edu.canastabasica.servicio.impl.ReportService;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	 @Autowired
	 @Qualifier("reporteServiceImpl")
	 private ReportService service;


	@GetMapping("/listarperiodos")
	public ModelAndView listAllPeriodos() {
		ModelAndView mav = new ModelAndView("periodoSondeo/listarperiodos");
		// mav.addObject("course", new Course());		
		mav.addObject("periodos", periodoSondeoService.listAllPeriodos());		
		return mav;
	}
    // Vista que muestra el formulario para registrar periodo
	@GetMapping("/registrarperiodo")
	public ModelAndView createPeriodoSondeo() {
		ModelAndView mav = new ModelAndView("periodoSondeo/registrarperiodo");
		mav.addObject("periodo", new PeriodoSondeo());
		return mav;
    }
    
    @GetMapping("/addperiodo")
	public @ResponseBody String addPeriodo(@ModelAttribute("periodo") PeriodoSondeo periodo) {
		periodo.setFinalizado(false);		
		periodoSondeoService.addPeriodoSondeo(periodo);
		return "registrado con exito";
	}

	//carga la vista
	@GetMapping("/editarperiodo")
	public ModelAndView editPeriodo(@RequestParam(name="id", required=true) Long id) {
		ModelAndView mav = new ModelAndView("periodoSondeo/editarperiodo");
		
		mav.addObject("periodo",periodoSondeoService.findById(id) );
		return mav;
	}
	// Ejecuta el update en la bd
	@GetMapping("/updateperiodo")
	public @ResponseBody String updatePeriodo(@ModelAttribute("periodo") PeriodoSondeo periodo) {
		System.out.println(periodo.isFinalizado());
		if(periodo.isFinalizado()){
        periodo.setFinalizado(true);
		}
		periodoSondeoService.updatePeriodoSondeo(periodo);
		return "editado con exito";
	}
	@GetMapping("/finalizarperiodo")
	public @ResponseBody String finalizarPeriodo(@RequestParam(name="id") Long id) {
		periodoSondeoService.finalizarPeriodo(id);
		return "editado con éxito";		
	}
	
	@GetMapping("/report")
    public String generateReport() throws FileNotFoundException, JRException {
        return service.exportReport();
    }
    
}