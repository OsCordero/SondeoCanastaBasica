package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Departamento;
import com.too.ues.edu.canastabasica.repo.DepartamentoRepo;
import com.too.ues.edu.canastabasica.servicio.DepartamentoService;

@Service("departamentoServiceImpl")
public class DepartamentoImpl implements DepartamentoService {

	@Autowired
	@Qualifier("DepartamentoRepo")
	private DepartamentoRepo departamentoRepo;
	
	@Override
	public List<Departamento> listAllDepartamentos() {
		return departamentoRepo.findAll();
	}
	
	@Override
	public Departamento findById(Long id) {
		return departamentoRepo.getOne(id);
	}
}
