package com.too.ues.edu.canastabasica.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.repo.PeriodoSondeoRepo;
import com.too.ues.edu.canastabasica.servicio.PeriodoSondeoService;

@Service("periodoSondeoImpl")
public class PeriodoSondeoImpl implements PeriodoSondeoService{

	@Autowired
	@Qualifier("PeriodoSondeoRepo")
	private PeriodoSondeoRepo periodoSondeoRepo;
	
	@Override
	public PeriodoSondeo addPeriodoSondeo(PeriodoSondeo periodo) {
		return periodoSondeoRepo.save(periodo); 
	}

	
}
