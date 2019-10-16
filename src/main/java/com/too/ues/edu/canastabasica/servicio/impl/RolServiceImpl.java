package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Rol;
import com.too.ues.edu.canastabasica.repo.RolRepo;
import com.too.ues.edu.canastabasica.servicio.RolService;

@Service("rolServiceImpl")
public class RolServiceImpl implements RolService{

	@Autowired
	@Qualifier("rolRepo")
	private RolRepo rolRepo;

	@Override
	public List<Rol> listAllRoles() {
		return rolRepo.findAll();
	}

	@Override
	public Rol findById(Long id) {
		return rolRepo.getOne(id);
	}
	
	
}
