package com.too.ues.edu.canastabasica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.too.ues.edu.canastabasica.model.Rol;
import com.too.ues.edu.canastabasica.model.Usuario;
import com.too.ues.edu.canastabasica.repo.IUsuarioRepo;
import com.too.ues.edu.canastabasica.servicio.RolService;
import com.too.ues.edu.canastabasica.servicio.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("rolServiceImpl")
	private RolService rolService;
	
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

	// Vista que muestra listar todos los usuarios
	@GetMapping("/listarusuarios")
	public ModelAndView listAllUsuarios() {
		ModelAndView mav = new ModelAndView("listarusuarios");
		//mav.addObject("course", new Course());
		mav.addObject("usuarios", usuarioService.listAllUsuarios());
		return mav;
	}
	
	// Vista que muestra el formulario para registrar usuario
	@GetMapping("/registrarusuario")
	public ModelAndView createUsuario() {
		ModelAndView mav = new ModelAndView("registrarusuario");
		//mav.addObject("roles", rolService.listAllRoles());
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	// Guardar usuario y redireccionar a listar usuarios
	@PostMapping("/addusuario")
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario) {
		//usuario.setRol(rol);
		//usuario.setPassword(encoder.encode(usuario.getPassword()));
		usuarioService.addUsuario(usuario);
		return "redirect:/listarusuarios";
	}
}
