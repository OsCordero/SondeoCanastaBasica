package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Departamento;

public interface DepartamentoService {
	
	public abstract List<Departamento> listAllDepartamentos();
	public abstract Departamento findById(Long id);
}
