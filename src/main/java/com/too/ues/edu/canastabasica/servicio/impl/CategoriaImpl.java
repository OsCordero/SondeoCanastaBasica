package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Categoria;
import com.too.ues.edu.canastabasica.repo.CategoriaRepo;
import com.too.ues.edu.canastabasica.servicio.CategoriaService;

@Service("categoriaServiceImpl")
public class CategoriaImpl implements CategoriaService {

	@Autowired
	@Qualifier("CategoriaRepo")
	private CategoriaRepo categoriaRepo;
	
	@Override
	public List<Categoria> listAllCategorias() {
		return categoriaRepo.findAll();
	}
	
	@Override
	public Categoria findById(Long id) {
		return categoriaRepo.getOne(id);
	}
}
