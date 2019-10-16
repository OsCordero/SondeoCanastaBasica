package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> listAllUsuarios();
	public abstract Usuario addUsuario(Usuario course);
	public abstract int removeUsuario(int id);
	public abstract Usuario updateUsuario(Usuario course);
	
}
