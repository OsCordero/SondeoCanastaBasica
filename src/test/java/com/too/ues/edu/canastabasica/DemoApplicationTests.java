package com.too.ues.edu.canastabasica;

import com.too.ues.edu.canastabasica.model.Usuario;
import com.too.ues.edu.canastabasica.model.Rol;
import com.too.ues.edu.canastabasica.repo.IUsuarioRepo;
import com.too.ues.edu.canastabasica.repo.RolRepo;
import com.too.ues.edu.canastabasica.servicio.RolService;
import com.too.ues.edu.canastabasica.servicio.UsuarioService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private RolRepo repoR;
	
	@Autowired
	@Qualifier("rolServiceImpl")
	private RolService rolService;
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void createRoles() {

		Rol rol1 = new Rol();
		rol1.setRol("ROLE_ADMIN");
		Rol rolretorno1 = repoR.save(rol1);

		Rol rol2 = new Rol();
		rol2.setRol("ROLE_USER");
		Rol rolretorno2 = repoR.save(rol2);

	}
	
	// Test para crear usuarios en bd
	@Test
	public void createUsuario() {
		
		List<Rol> roles = rolService.listAllRoles();
		
		Set<Rol> roles1 = new HashSet<Rol>();
		roles1.add(roles.get(0));
		
		Usuario us = new Usuario();
		// us.setIdUsuario(Long.parseLong("1"));
		us.setEnabled(true);
		us.setPassword(encoder.encode("password"));
		us.setUsername("Prueba");
		us.setNombre("Andrés Castro");
		us.setCorreo("andres@gmail.com");
		us.setRol(roles1);
		Usuario retorno = usuarioService.addUsuario(us);

		Set<Rol> roles2 = new HashSet<Rol>();
		roles2.add(roles.get(0));
		
		Usuario usDos = new Usuario();
		// usDos.setIdUsuario(Long.parseLong("2"));
		usDos.setEnabled(true);
		usDos.setPassword(encoder.encode("password"));
		usDos.setUsername("Test");
		usDos.setNombre("Roberto Ventura");
		usDos.setCorreo("roberto@gmail.com");
		usDos.setRol(roles2);
		Usuario retornoDos = usuarioService.addUsuario(usDos);
		
	}

}
