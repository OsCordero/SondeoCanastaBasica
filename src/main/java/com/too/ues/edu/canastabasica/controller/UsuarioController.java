package com.too.ues.edu.canastabasica.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.*;

import com.too.ues.edu.canastabasica.model.Rol;
import com.too.ues.edu.canastabasica.model.Usuario;
import com.too.ues.edu.canastabasica.repo.IUsuarioRepo;
import com.too.ues.edu.canastabasica.servicio.RolService;
import com.too.ues.edu.canastabasica.servicio.UsuarioService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
	
    private Session session;
    private DataSourceFactory dataSourceFactory;

	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;

	@Autowired
	@Qualifier("rolServiceImpl")
	private RolService rolService;

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	//No debería estar aquí este mapping, lo he puesto temporalmente (Andrés)
	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView mav=new ModelAndView("login");		
		return mav;
	}

	// Vista que muestra listar todos los usuarios
	@GetMapping("/listarusuarios")
	public ModelAndView listAllUsuarios() {
		ModelAndView mav = new ModelAndView("listarusuarios");
		// mav.addObject("course", new Course());		
		mav.addObject("usuarios", usuarioService.listAllUsuarios());		
		return mav;
	}
	
	// Vista que muestra listar todos los usuarios para ajax
	@GetMapping("/todosusuariosajax")
	public @ResponseBody List<Usuario> todosAllUsuarios() {
		List<Usuario> users = usuarioService.listAllUsuarios();		
		return users;
	}

	// Vista que muestra el formulario para registrar usuario
	@GetMapping("/registrarusuario")
	public ModelAndView createUsuario() {
		ModelAndView mav = new ModelAndView("registrarusuario");
		mav.addObject("roles", rolService.listAllRoles());
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	// Vista que muestra el formulario para editar usuario
	@GetMapping("/editarusuario")
	public ModelAndView editUsuario(@RequestParam(name="id", required=true) Long id) {
		ModelAndView mav = new ModelAndView("editarusuario");
		mav.addObject("usuario", usuarioService.findUsuarioById(id));
		mav.addObject("roles", rolService.listAllRoles());
		return mav;
	}
	
	@GetMapping("/addusuario")
	public @ResponseBody String addUsuario(@ModelAttribute("usuario") Usuario usuario, @RequestParam(name="rol_add") String rol_id) {
		
		long id = Long.parseLong(rol_id);
		Rol rol = rolService.findById(id);
		Set<Rol> roles = new HashSet<Rol>();
		roles.add(rol);
		
		usuario.setPassword( encoder.encode(usuario.getPassword()) );		
		usuario.setRol(roles);
		usuario.setEnabled(true);		
	
		usuarioService.addUsuario(usuario);
			
		return "registrado con exito";
	}
	
	// Actualizar usuario y redireccionar a listar usuarios
	@GetMapping("/updateusuario")
	public @ResponseBody String updateUsuario(@ModelAttribute("usuario") Usuario usuario, @RequestParam(name="rol_add") String rol_id) {
		
		long id = Long.parseLong(rol_id);
		Rol rol = rolService.findById(id);
		Set<Rol> roles = new HashSet<Rol>();
		roles.add(rol);
		
		usuario.setRol(roles);
		usuario.setEnabled(true);
		if (usuario.getPassword() == "") {
			Usuario us = usuarioService.findUsuarioById(usuario.getIdUsuario());
			usuario.setPassword(us.getPassword());//tengo mis dudas sobre si la desencripta al llamar y al guarda desencriptada
		}
		else{
			usuario.setPassword(encoder.encode(usuario.getPassword()));
		}
		
		usuarioService.updateUsuario(usuario);
		return "editado con éxito";		
	}
	
	// Eliminar Usuario y redireccionar a listarusuario
	@GetMapping("/eliminarusuario")
	public String deleteUsuario(@RequestParam(name="id", required=true) Long id) {
		usuarioService.deleteUsuario(id);
		return "redirect:/listarusuarios";
	}
}
