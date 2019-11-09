package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Rol;
import com.too.ues.edu.canastabasica.model.RegistroSondeo;
import com.too.ues.edu.canastabasica.repo.RegistroSondeoRepo;
import com.too.ues.edu.canastabasica.servicio.RegistroSondeoService;

@Service("registroSondeoServiceImpl")
public class RegistroSondeoImpl implements RegistroSondeoService {

	@Autowired
	@Qualifier("RegistroSondeoRepo")
	private RegistroSondeoRepo registroSondeoRepo;
	
	@Override
	public List<RegistroSondeo> listAllRegistroSondeo() {
		return registroSondeoRepo.findAll();
	}

	@Override
	public RegistroSondeo addRegistroSondeo(RegistroSondeo registroSondeo) {
		return registroSondeoRepo.save(registroSondeo);
	}

	@Override
	public int deleteRegistroSondeo(Long id) {
		RegistroSondeo registroSondeo = this.findRegistroSondeoById(id);		
        registroSondeoRepo.delete(registroSondeo);
        //otra manera 
        //registroSondeoRepo.deleteById(id);
		return 0;
	}

	@Override
	public RegistroSondeo updateRegistroSondeo(RegistroSondeo registroSondeo) {
		registroSondeoRepo.save(registroSondeo);
		return null;
	}

	@Override
	public RegistroSondeo findRegistroSondeoById(Long id) {
		return registroSondeoRepo.getOne(id);
	}
	
}
