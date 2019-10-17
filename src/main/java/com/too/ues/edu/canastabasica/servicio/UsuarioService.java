package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> listAllUsuarios();
	public abstract Usuario addUsuario(Usuario usuario);
	public abstract int deleteUsuario(Long id);
	public abstract Usuario updateUsuario(Usuario usuario);
	public abstract Usuario findUsuarioById(Long id);
	
}
