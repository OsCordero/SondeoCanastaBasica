package com.too.ues.edu.canastabasica.controller;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.*;

import com.too.ues.edu.canastabasica.model.RegistroSondeo;
import com.too.ues.edu.canastabasica.model.SubCategoria;
import com.too.ues.edu.canastabasica.model.Producto;
import com.too.ues.edu.canastabasica.model.Categoria;
import com.too.ues.edu.canastabasica.model.Departamento;
import com.too.ues.edu.canastabasica.model.Municipio;
import com.too.ues.edu.canastabasica.model.Establecimiento;
import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.repo.RegistroSondeoRepo;
import com.too.ues.edu.canastabasica.repo.ProductoRepo;
import com.too.ues.edu.canastabasica.repo.EstablecimientoRepo;
import com.too.ues.edu.canastabasica.repo.PeriodoSondeoRepo;
import com.too.ues.edu.canastabasica.repo.CategoriaRepo;
import com.too.ues.edu.canastabasica.repo.DepartamentoRepo;
import com.too.ues.edu.canastabasica.servicio.RegistroSondeoService;
import com.too.ues.edu.canastabasica.servicio.RolService;
import com.too.ues.edu.canastabasica.servicio.SubCategoriaService;
import com.too.ues.edu.canastabasica.servicio.ProductoService;
import com.too.ues.edu.canastabasica.servicio.EstablecimientoService;
import com.too.ues.edu.canastabasica.servicio.PeriodoSondeoService;
import com.too.ues.edu.canastabasica.servicio.CategoriaService;
import com.too.ues.edu.canastabasica.servicio.DepartamentoService;
import com.too.ues.edu.canastabasica.servicio.MunicipioService;

import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegistroSondeoController {
	
	@PersistenceContext
	private EntityManager em;
	    
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
    @Qualifier("categoriaServiceImpl")
    private CategoriaService categoriaService;
    
    @Autowired
    @Qualifier("subCategoriaServiceImpl")
    private SubCategoriaService subcategoriaService;
    
    @Autowired
    @Qualifier("periodoSondeoImpl")
    private PeriodoSondeoService periodoSondeoService;

    @Autowired
    @Qualifier("departamentoServiceImpl")
    private DepartamentoService departamentoService;
    
    @Autowired
    @Qualifier("municipioServiceImpl")
    private MunicipioService municipioService;
    

    @Autowired
	@Qualifier("rolServiceImpl")
	private RolService rolService;

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
	public List<Municipio> listarMunicipios(@RequestParam(name="departamento_id") String departamento_id) {
		
		long dpto_id = Long.parseLong(departamento_id);
		Departamento departamento = departamentoService.findById(dpto_id);
		
		List<Municipio> municipios_completos = municipioService.listAllMunicipiosByDepartamento(departamento);
		
		List<Municipio> municipios = new ArrayList<Municipio>();
		
		for (Municipio municipio : municipios_completos) {
			Municipio municipio_pasar = new Municipio();
			municipio_pasar.setIdMunicipio(municipio.getIdMunicipio());
			municipio_pasar.setNombreMunicipio(municipio.getNombreMunicipio());
			municipios.add(municipio_pasar);
		}
		
		return municipios;
	}
	
	@GetMapping("/todosestablecimientossajax")
	public List<Establecimiento> listarEstablecimientos(@RequestParam(name="municipio_id") String municipio_id) {
		
		long mnp_id = Long.parseLong(municipio_id);
		Municipio municipio = municipioService.findById(mnp_id);
		
		List<Establecimiento> establecimientos_completos = establecimientoRepo.findByMunicipio(municipio);
		
		List<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
		
		for (Establecimiento establecimiento : establecimientos_completos) {
			Establecimiento establecimiento_pasar = new Establecimiento();
			establecimiento_pasar.setIdEstablecimiento(establecimiento.getIdEstablecimiento());
			establecimiento_pasar.setNombreEstablecimiento(establecimiento.getNombreEstablecimiento());
			establecimientos.add(establecimiento_pasar);
		}
		
		return establecimientos;
	}

	@GetMapping("/todossubcategoriasajax")
	public List<SubCategoria> listarSubcategoria(@RequestParam(name="categoria_id") String categoria_id) {
		
		long cat_id = Long.parseLong(categoria_id);
		Categoria categoria = categoriaService.findById(cat_id);
		
		List<SubCategoria> subcategoria_completos = subcategoriaService.listAllSubCategoriasByCategoria(categoria);
		//List<SubCategoria> subcategoria_completos = subcategoriaService.listAllSubCategorias();
		
		List<SubCategoria> subcategorias = new ArrayList<SubCategoria>();
		
		for (SubCategoria subcategoria : subcategoria_completos) {
			SubCategoria subcategoria_pasar = new SubCategoria();
			subcategoria_pasar.setIdSubCategoria(subcategoria.getIdSubCategoria());
			subcategoria_pasar.setNombreSubCategoria(subcategoria.getNombreSubCategoria());
			subcategorias.add(subcategoria_pasar);
		}
		
		return subcategorias;
	}

	
	@GetMapping("/todosproductosajax")
	public List<Object[]> listarProductos(@RequestParam(name="subcategoria_id") String subcategoria_id) {
		
		long sbcat_id = Long.parseLong(subcategoria_id);
		SubCategoria subcategoria = subcategoriaService.findById(sbcat_id);
		
		List<Producto> productos_completos = productoService.listAllProductosBySubCategoria(subcategoria);
		
		List<Object[]> objetos_producto = new ArrayList<Object[]>();
		
		for (Producto producto : productos_completos) {
			
			Object[] objeto = new Object[5];
			
			// ID Producto
			objeto[0] = producto.getIdProducto();
			// Nombre Producto
			objeto[1] = producto.getNombreProducto();
			// Marca
			objeto[2] = producto.getMarca().getNombreMarca();
			// Presentación
			objeto[3] = producto.getPresentacion();
			//Unidad
			objeto[4] = producto.getUnidadMedida().getAbreviatura();
			
			objetos_producto.add(objeto);
		}
		
		return objetos_producto;
	}
	
	// Vista que muestra el formulario para registrar usuario
	@GetMapping("/registrarregistrosondeo")
	public ModelAndView createRegistroSondeo() {
        ModelAndView mav = new ModelAndView("registrarregistrosondeo");		
        /* mandamos a llamar los productos,establecimientos y periodoso*/
        //List<Producto> productos= productoService.listAllProducto();
        List<Categoria> listaCategoria = categoriaService.listAllCategorias();
        mav.addObject("listaCategoria", listaCategoria);

        List<Departamento> departamentos=departamentoService.listAllDepartamentos();
        mav.addObject("listaDepartamentos", departamentos);

        List<PeriodoSondeo> periodoSondeos=periodoSondeoRepo.findAll();
        List<PeriodoSondeo> periodoSondeosHabilitados= new ArrayList<>();
        for(PeriodoSondeo periodo:periodoSondeos){
            if(periodo.isFinalizado()==false){
                periodoSondeosHabilitados.add(periodo);
            }
        }
        mav.addObject("listaPeriodoSondeo", periodoSondeosHabilitados);

        //objeto de interés 
		mav.addObject("registroSondeo", new RegistroSondeo());
		return mav;
	}
			
	@GetMapping("/addregistrosondeo")
	public @ResponseBody ModelAndView addRegistroSondeo(@ModelAttribute("registroSondeo") RegistroSondeo registroSondeo, @RequestParam(name="periodo_add") String periodo_id, @RequestParam(name="producto_add") String producto_id,@RequestParam(name="establecimiento_add") String establecimiento_id) {
    
        PeriodoSondeo periodoSondeo = periodoSondeoRepo.getOne(Long.parseLong(periodo_id));
        
        Producto producto= productoService.findProductoById(Long.parseLong(producto_id));
        
        Establecimiento establecimiento= establecimientoService.findEstablecimientoById(Long.parseLong(establecimiento_id));

        registroSondeo.setPeriodoSondeo(periodoSondeo);
        registroSondeo.setProducto(producto);
        registroSondeo.setEstablecimiento(establecimiento);
                      

        registroSondeoService.addRegistroSondeo(registroSondeo);        
        return new ModelAndView ("redirect:/registrarregistrosondeo?periodo_id="+periodo_id+"&save=1");
	}
	
	@GetMapping("/listarperiodosondeo")
	public ModelAndView listAllPeriodos() {
        ModelAndView mav = new ModelAndView("registroSondeo/listarProductoSondeo");	
    
        List<PeriodoSondeo> periodoSondeos=periodoSondeoRepo.findAll();
        List<PeriodoSondeo> periodoSondeosHabilitados= new ArrayList<>();
        for(PeriodoSondeo periodo:periodoSondeos){
            if(periodo.isFinalizado()==false){
                periodoSondeosHabilitados.add(periodo);
            }
        }
        mav.addObject("listaPeriodoSondeo", periodoSondeosHabilitados);
        mav.addObject("registroSondeo", periodoSondeoService.listAllPeriodos());
		return mav;
	}
	
	
	
	@GetMapping("/registrossondeos")
	public ModelAndView listAllRegistroSondeoByPeriodoSondeo(@RequestParam(name="periodo_id") String periodo_id) {
        ModelAndView mav = new ModelAndView("registroSondeo/listarRegistroSondeo");
        long sbcat_id = Long.parseLong(periodo_id);
		PeriodoSondeo periodoSondeo = periodoSondeoService.findById(sbcat_id);
		
		List<RegistroSondeo> registro_sondeo = registroSondeoService.listAllRegistroSondeoByPeriodoSondeo(periodoSondeo);
		
		List<RegistroSondeo> sondeos = new ArrayList<RegistroSondeo>();
		
		for (RegistroSondeo sondeo : registro_sondeo) {
			RegistroSondeo sondeo_pasar = new RegistroSondeo();
			sondeo_pasar.setPrecio(sondeo.getPrecio());
			sondeo_pasar.setPeso(sondeo.getPeso());
			sondeo_pasar.setEstablecimiento(sondeo.getEstablecimiento());
			sondeo_pasar.setProducto(sondeo.getProducto());
			sondeos.add(sondeo_pasar);
		}
		
		mav.addObject("listaRegistroSondeo", sondeos);
		mav.addObject("periodo", periodoSondeo);
        mav.addObject("registroSondeo", registroSondeoService.listAllRegistroSondeoByPeriodoSondeo(periodoSondeo));
		return mav;
        
	}
	
	@GetMapping("/eliminarregistro/{periodo_id}/{producto_id}/{establecimiento_id}")
    public @ResponseBody ModelAndView eliminar(@PathVariable(value="periodo_id") Long idPeriodo, @PathVariable(value="producto_id") Long idProducto,@PathVariable(value="establecimiento_id") Long idEstablecimiento ) {
	
		PeriodoSondeo periodoSondeo = periodoSondeoService.findById(idPeriodo);
		Producto producto= productoService.findProductoById(idProducto);
		Establecimiento establecimiento= establecimientoService.findEstablecimientoById(idEstablecimiento);
		
		//return "Datos:"+idProducto.toString()+idPeriodo.toString()+idEstablecimiento.toString();
		
		//RegistroSondeo registro = registroSondeoService.findByPeriodoSondeoAndProducto(periodoSondeo, producto);
		RegistroSondeo registroSondeo=registroSondeoRepo.findByPeriodoSondeoAndEstablecimientoAndProducto(periodoSondeo, establecimiento, producto);
		registroSondeoRepo.delete(registroSondeo);
		String periodo = idPeriodo.toString();
		return new ModelAndView ("redirect:/registrossondeos?periodo_id="+periodo+"&save=1");	
	}
	
	// Vista que muestra el formulario para registrar usuario
	@GetMapping("/editarregistro")
	public ModelAndView actualizarRegistroSondeo(@RequestParam(name="periodo_id") Long idPeriodo, @RequestParam(name="establecimiento_id") Long idEstablecimiento, @RequestParam(name="producto_id") Long idProducto) {
        ModelAndView mav = new ModelAndView("registroSondeo/editarRegistroSondeo");
		PeriodoSondeo periodoSondeo= periodoSondeoService.findById(idPeriodo);
		Establecimiento establecimiento= establecimientoService.findEstablecimientoById(idEstablecimiento);
		Producto producto= productoService.findProductoById(idProducto);		
		RegistroSondeo registroSondeo=registroSondeoRepo.findByPeriodoSondeoAndEstablecimientoAndProducto(periodoSondeo, establecimiento, producto);
		System.out.println(registroSondeo.toString());
        //objeto de interés 
		mav.addObject("registroSondeo", registroSondeo);
		return mav;
	}
			
	@GetMapping("/updateregistrosondeo")
	public @ResponseBody ModelAndView updateRegistroSondeo(@ModelAttribute("registroSondeo") RegistroSondeo registroSondeo, @RequestParam(name="periodo_add") String periodo_id, @RequestParam(name="producto_add") String producto_id,@RequestParam(name="establecimiento_add") String establecimiento_id) {
		
		PeriodoSondeo periodoSondeo = periodoSondeoRepo.getOne(Long.parseLong(periodo_id));
			
		Producto producto= productoService.findProductoById(Long.parseLong(producto_id));
		
		Establecimiento establecimiento= establecimientoService.findEstablecimientoById(Long.parseLong(establecimiento_id));	
		registroSondeo.setPeriodoSondeo(periodoSondeo);
		registroSondeo.setProducto(producto);
		registroSondeo.setEstablecimiento(establecimiento);
        registroSondeoService.updateRegistroSondeo(registroSondeo);
		return new ModelAndView ("redirect:/editarregistro?periodo_id="+periodo_id+"&establecimiento_id="+establecimiento_id+"&producto_id="+producto_id+"&save=1");		
	}	
	
	@GetMapping("/consulta")
	public List<Object[]> consultaReporte(){
		Long id=(long) 1;
	        Query nativeQuery = em.createNativeQuery("SELECT RE.PESO,\r\n" + 
	        		"RE.PRECIO, PR.NOMBRE_PRODUCTO, PR.ABREVIATURA, ES.NOMBRE_ESTABLECIMIENTO, M.NOMBRE_MUNICIPIO, D.NOMBRE_DEPARTAMENTO\r\n" + 
	        		"FROM PERIODO_SONDEO PE JOIN REGISTRO_SONDEO RE\r\n" + 
	        		"ON PE.ID_PERIODO = RE.ID_PERIODO\r\n" + 
	        		"JOIN PRODUCTO PR ON RE.ID_PRODUCTO = PR.ID_PRODUCTO\r\n" + 
	        		"JOIN ESTABLECIMIENTO ES ON RE.ID_ESTABLECIMIENTO = ES.ID_ESTABLECIMIENTO\r\n" + 
	        		"JOIN MUNICIPIO M ON ES.ID_MUNICIPIO = M.ID_MUNICIPIO \r\n" + 
	        		"JOIN DEPARTAMENTO D ON M.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO\r\n" + 
	        		"ORDER BY D.ID_DEPARTAMENTO");
	        //((javax.persistence.Query) nativeQuery).setParameter(1, id);        
	        return nativeQuery.getResultList();
	        
	       
	}
		
}

