package com.too.ues.edu.canastabasica.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.repo.PeriodoSondeoRepo;
import com.too.ues.edu.canastabasica.servicio.PeriodoSondeoService;

@Service("periodoSondeoImpl")
public class PeriodoSondeoImpl implements PeriodoSondeoService {

	@Autowired
	@Qualifier("PeriodoSondeoRepo")
	private PeriodoSondeoRepo periodoSondeoRepo;

	@Override
	public PeriodoSondeo addPeriodoSondeo(PeriodoSondeo periodo) {
		return periodoSondeoRepo.save(periodo);
	}

	@Override
	public PeriodoSondeo updatePeriodoSondeo(PeriodoSondeo periodo) {
		periodoSondeoRepo.save(periodo);
		return null;
	}
	@Override
	public List<PeriodoSondeo> listAllPeriodos() {
		return periodoSondeoRepo.findAll();
	}

	@Override
	public PeriodoSondeo findById(Long id) {
		return periodoSondeoRepo.getOne(id);
	}

	@Override
	public int finalizarPeriodo(Long id) {
		PeriodoSondeo periodo = this.findById(id);
		periodo.setFinalizado(true);
		periodoSondeoRepo.save(periodo);
		return 0;
	}


	
}
