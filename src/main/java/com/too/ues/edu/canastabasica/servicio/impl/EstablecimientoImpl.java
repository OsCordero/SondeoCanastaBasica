package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Establecimiento;
import com.too.ues.edu.canastabasica.model.Municipio;
import com.too.ues.edu.canastabasica.repo.EstablecimientoRepo;
import com.too.ues.edu.canastabasica.servicio.EstablecimientoService;

@Service("establecimientoServiceImpl")
public class EstablecimientoImpl implements EstablecimientoService {

	@Autowired
	@Qualifier("EstablecimientoRepo")
	private EstablecimientoRepo establecimientoRepo;

	@Override
	public List<Establecimiento> listAllEstablecimiento() {
		return establecimientoRepo.findAll();
	}
	
	@Override
	public List<Establecimiento> listAllEstablecimientosByMunicipio(Municipio municipio) {		
		return establecimientoRepo.findByMunicipio(municipio);
	}

	@Override
	public Establecimiento findEstablecimientoById(Long idEstablecimiento) {		
		return establecimientoRepo.getOne(idEstablecimiento);
	}
    
}
