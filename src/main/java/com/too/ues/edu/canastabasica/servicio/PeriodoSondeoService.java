package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.PeriodoSondeo;

public interface PeriodoSondeoService {

	public abstract List<PeriodoSondeo> listAllPeriodos();
	public abstract PeriodoSondeo addPeriodoSondeo(PeriodoSondeo periodo);
	public abstract PeriodoSondeo findById(Long id);
	public abstract int finalizarPeriodo(Long id);
}
