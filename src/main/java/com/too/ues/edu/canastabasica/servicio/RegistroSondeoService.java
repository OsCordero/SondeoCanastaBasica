package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.RegistroSondeo;

public interface RegistroSondeoService {
	
	public abstract List<RegistroSondeo> listAllRegistroSondeo();
	public abstract RegistroSondeo addRegistroSondeo(RegistroSondeo registroSondeo);
	public abstract int deleteRegistroSondeo(Long id);
	public abstract RegistroSondeo updateRegistroSondeo(RegistroSondeo registroSondeo);
	public abstract RegistroSondeo findRegistroSondeoById(Long id);
	
}
