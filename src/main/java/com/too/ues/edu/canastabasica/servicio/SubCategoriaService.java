package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Categoria;
import com.too.ues.edu.canastabasica.model.SubCategoria;

public interface SubCategoriaService {
	
	public abstract List<SubCategoria> listAllSubCategorias();
	public abstract List<SubCategoria> listAllSubCategoriasByCategoria(Categoria categoria);
	public abstract SubCategoria findById(Long id);
}
