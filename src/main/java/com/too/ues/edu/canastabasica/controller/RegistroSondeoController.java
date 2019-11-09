package com.too.ues.edu.canastabasica.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.*;

import com.too.ues.edu.canastabasica.model.RegistroSondeo;
import com.too.ues.edu.canastabasica.model.Producto;
import com.too.ues.edu.canastabasica.model.Departamento;
import com.too.ues.edu.canastabasica.model.Municipio;
import com.too.ues.edu.canastabasica.model.Establecimiento;
import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.repo.RegistroSondeoRepo;
import com.too.ues.edu.canastabasica.repo.ProductoRepo;
import com.too.ues.edu.canastabasica.repo.EstablecimientoRepo;
import com.too.ues.edu.canastabasica.repo.PeriodoSondeoRepo;
import com.too.ues.edu.canastabasica.repo.DepartamentoRepo;
import com.too.ues.edu.canastabasica.servicio.RegistroSondeoService;
import com.too.ues.edu.canastabasica.servicio.ProductoService;
import com.too.ues.edu.canastabasica.servicio.EstablecimientoService;
import com.too.ues.edu.canastabasica.servicio.PeriodoSondeoService;
import com.too.ues.edu.canastabasica.servicio.DepartamentoService;
import com.too.ues.edu.canastabasica.servicio.MunicipioService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegistroSondeoController {
	    
	@Autowired
	@Qualifier("registroSondeoServiceImpl")
	private RegistroSondeoService registroSondeoService;

    @Autowired
    @Qualifier("productoServiceImpl")
    private ProductoService productoService;
    
    @Autowired
    @Qualifier("establecimientoServiceImpl")
    private EstablecimientoService establecimientoService;

    @Autowired
    @Qualifier("periodoSondeoImpl")
    private PeriodoSondeoService periodoSondeoService;

    @Autowired
    @Qualifier("departamentoImpl")
    private DepartamentoService departamentoService;
    

    /*@Autowired
	@Qualifier("rolServiceImpl")
	private RolService rolService;*/

	@Autowired
    private RegistroSondeoRepo registroSondeoRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private EstablecimientoRepo establecimientoRepo;
    
    @Autowired
    private PeriodoSondeoRepo periodoSondeoRepo;
    

	/*@Autowired
	private BCryptPasswordEncoder encoder;*/
	
	
	// Vista que muestra listar todos los usuarios
	@GetMapping("/listarregistrosondeos")
	public ModelAndView listAllRegistroSondeo() {
		ModelAndView mav = new ModelAndView("listarregistrosondeos");		
		mav.addObject("registroSondeos", registroSondeoService.listAllRegistroSondeo());		
		return mav;
	}
    
    /*

	// Vista que muestra listar todos los usuarios para ajax
	@GetMapping("/todosusuariosajax")
	public @ResponseBody List<Usuario> todosAllUsuarios() {
		List<Usuario> users = usuarioService.listAllUsuarios();		
        return users;        
    }*/
    

    @GetMapping("/todosmunicipiosajax")
	public @ResponseBody List<Municipio> listaMunicipios(Departamento departamento) {		
        //municipio
        //return MunicipioService;
        return null;
    }


	// Vista que muestra el formulario para registrar usuario
	@GetMapping("/registrarregistrosondeo")
	public ModelAndView createRegistroSondeo() {
        ModelAndView mav = new ModelAndView("registrarregistrosondeo");		
        /* mandamos a llamar los productos,establecimientos y periodoso*/
        List<Producto> productos= productoService.listAllProducto();
        mav.addObject("listaProductos", productos);

        List<Departamento> departamentos=departamentoService.listAllDepartamentos();
        mav.addObject("listaDepartamentos", departamentos);

        List<PeriodoSondeo> periodoSondeos=periodoSondeoRepo.findAll();
        mav.addObject("listaPeriodoSondeo", periodoSondeos);

        //objeto de interés 
		mav.addObject("registroSondeo", new RegistroSondeo());
		return mav;
	}
			
	@GetMapping("/addregistrosondeo")
	public @ResponseBody String addRegistroSondeo(@ModelAttribute("registroSondeo") RegistroSondeo registroSondeo, @RequestParam(name="periodo_add") String periodo_id, @RequestParam(name="producto_add") String producto_id,@RequestParam(name="establecimiento_add") String establecimiento_id) {
            
        long idPeriodo= Long.parseLong(periodo_id);
        long idProducto=Long.parseLong(producto_id);
        long idEstablecimiento=Long.parseLong(establecimiento_id);

        PeriodoSondeo periodoSondeo = periodoSondeoRepo.getOne(idPeriodo);
        
        Producto producto= productoService.findProductoById(idProducto);
        
        //Establecimiento establecimiento= establecimientoService.findEstablecimientoById(idEstablecimiento);

        registroSondeo.setPeriodoSondeo(periodoSondeo);
        registroSondeo.setProducto(producto);
        //registroSondeo.setEstablecimiento(establecimiento);
        
        //Aqui lo seteo a la fuerza
        registroSondeo.setPeso("2");
        registroSondeo.setPrecio("3");

        registroSondeoService.addRegistroSondeo(registroSondeo);
        /*long id = Long.parseLong(rol_id);
		Rol rol = rolService.findById(id);
		Set<Rol> roles = new HashSet<Rol>();
		roles.add(rol);
		
		usuario.setPassword( encoder.encode(usuario.getPassword()) );		
		usuario.setRol(roles);
		usuario.setEnabled(true);		
	
        usuarioService.addUsuario(usuario);
        return "redirect:/listarregistrosondeos"        
        */			
		return "registrado con exito";
	}
    
    
}

