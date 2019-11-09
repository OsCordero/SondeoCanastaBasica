package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Establecimiento;

public interface EstablecimientoService {
	
	public abstract List<Establecimiento> listAllEstablecimiento();	
	public abstract Establecimiento findEstablecimientoById(Long id);
}
