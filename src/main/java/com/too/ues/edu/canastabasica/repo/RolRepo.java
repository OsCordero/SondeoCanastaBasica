package com.too.ues.edu.canastabasica.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.too.ues.edu.canastabasica.model.Rol;

@Repository("rolRepo")
public interface RolRepo extends JpaRepository<Rol, Serializable>{
	
	
}
