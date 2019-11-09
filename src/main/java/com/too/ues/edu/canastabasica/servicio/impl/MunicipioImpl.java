package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Departamento;
import com.too.ues.edu.canastabasica.model.Municipio;
import com.too.ues.edu.canastabasica.repo.DepartamentoRepo;
import com.too.ues.edu.canastabasica.repo.MunicipioRepo;
import com.too.ues.edu.canastabasica.servicio.DepartamentoService;
import com.too.ues.edu.canastabasica.servicio.MunicipioService;

@Service("municipioServiceImpl")
public class MunicipioImpl implements MunicipioService {

	@Autowired
	@Qualifier("MunicipioRepo")
	private MunicipioRepo municipioRepo;
	
	@Override
	public List<Municipio> listAllMunicipios() {
		return municipioRepo.findAll();
	}
	
	@Override
	public List<Municipio> listAllMunicipiosByDepartamento(Departamento departamento){
        return municipioRepo.findByDepartamento(departamento);
	}

	@Override
	public Municipio findById(Long id) {
		return municipioRepo.getOne(id);
	}
	
}

