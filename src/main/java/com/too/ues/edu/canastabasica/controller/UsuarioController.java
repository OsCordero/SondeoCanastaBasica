package com.too.ues.edu.canastabasica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.too.ues.edu.canastabasica.model.Usuario;
import com.too.ues.edu.canastabasica.repo.IUsuarioRepo;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepo repo;

	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/prueba")
	public String home() {
		return "prueba";
	}

	@GetMapping("/usuario")
	public String usuario(@RequestParam(name = "name", required=false, defaultValue="Robert") String name, Model model) {
				
		/*Usuario u = new Usuario();
		u.setIdUsuario(Long.parseLong("50"));
		u.setUsername("Mabi");
		u.setPassword(encoder.encode("password"));
		u.setEnabled(true);
		repo.save(u);*/
		
		model.addAttribute("name", name);
		return "usuario";
	}

	
	
}
