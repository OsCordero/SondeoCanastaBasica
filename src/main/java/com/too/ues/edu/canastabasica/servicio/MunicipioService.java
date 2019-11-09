package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Municipio;
import com.too.ues.edu.canastabasica.model.Departamento;

public interface MunicipioService {
	
	public abstract List<Municipio> listAllMunicipiosByDepartamento(Departamento departamento);
}
