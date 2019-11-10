package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Categoria;

public interface CategoriaService {
	
	public abstract List<Categoria> listAllCategorias();
	public abstract Categoria findById(Long id);
}
