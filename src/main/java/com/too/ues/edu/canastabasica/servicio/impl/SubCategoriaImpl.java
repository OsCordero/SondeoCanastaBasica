package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.SubCategoria;
import com.too.ues.edu.canastabasica.repo.SubCategoriaRepo;
import com.too.ues.edu.canastabasica.servicio.SubCategoriaService;

@Service("subCategoriaServiceImpl")
public class SubCategoriaImpl implements SubCategoriaService {

	@Autowired
	@Qualifier("SubCategoriaRepo")
	private SubCategoriaRepo subCategoriaRepo;
	
	@Override
	public List<SubCategoria> listAllSubCategorias() {
		return subCategoriaRepo.findAll();
	}
	
	@Override
	public SubCategoria findById(Long id) {
		return subCategoriaRepo.getOne(id);
	}
}
