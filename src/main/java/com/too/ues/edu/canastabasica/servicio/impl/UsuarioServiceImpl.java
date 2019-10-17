package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Rol;
import com.too.ues.edu.canastabasica.model.Usuario;
import com.too.ues.edu.canastabasica.repo.IUsuarioRepo;
import com.too.ues.edu.canastabasica.servicio.UsuarioService;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	@Qualifier("IUsuarioRepo")
	private IUsuarioRepo iusuarioRepo;
	
	@Override
	public List<Usuario> listAllUsuarios() {
		return iusuarioRepo.findAll();
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		return iusuarioRepo.save(usuario);
	}

	@Override
	public int deleteUsuario(Long id) {
		iusuarioRepo.deleteById(id);
		return 0;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {		
		iusuarioRepo.save(usuario);
		return null;
	}

	@Override
	public Usuario findUsuarioById(Long id) {
		return iusuarioRepo.getOne(id);
	}
	
}
