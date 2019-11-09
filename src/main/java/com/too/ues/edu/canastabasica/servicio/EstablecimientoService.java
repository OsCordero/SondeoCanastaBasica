package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Establecimiento;
import com.too.ues.edu.canastabasica.model.Municipio;

public interface EstablecimientoService {
	
	public abstract List<Establecimiento> listAllEstablecimiento();	
	public abstract List<Establecimiento> listAllEstablecimientosByMunicipio(Municipio municipio);	
	public abstract Establecimiento findEstablecimientoById(Long idEstablecimiento);
}
