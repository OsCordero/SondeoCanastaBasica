package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Rol;

public interface RolService {

	public abstract List<Rol> listAllRoles();
	public abstract Rol findById(Long id);
	
}
