package com.too.ues.edu.canastabasica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String rol;
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol= rol;
	}
}