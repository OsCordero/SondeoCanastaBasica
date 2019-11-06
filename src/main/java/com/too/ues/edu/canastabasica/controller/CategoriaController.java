package com.too.ues.edu.canastabasica.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.too.ues.edu.canastabasica.model.Categoria;
import com.too.ues.edu.canastabasica.repo.CategoriaRepo;
import com.too.ues.edu.canastabasica.repo.SubCategoriaRepo;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriaController{
    
    @Autowired
    private CategoriaRepo categoriaRepo;

    @Autowired
    private SubCategoriaRepo subCategoriaRepo;
    
    @GetMapping("/categorias")
    public List<Categoria> getCategorias(){
        return categoriaRepo.findAll();
    }

    // Vista que muestra la lista de las categorias
	@GetMapping("/listarcategorias")
	public ModelAndView listAllCategorias() {
        ModelAndView mav = new ModelAndView("listarcategorias");		        
        List<Categoria> categorias=categoriaRepo.findAll();
        for(Categoria categoria:categorias){
            categoria.setSubCategorias(subCategoriaRepo.findByCategoria(categoria));
        }
		mav.addObject("categorias",categorias);
		return mav;
    }    

    /*@GetMapping("/categorias/{id}")
    public ResponseEntity <Categoria> getCategoriaById(
        @PathVariable(value="id") Long categoriaId)  throws ResourceNotFoundException{
         Categoria categoria=categoriaRepo.findById(categoriaId).orElseThrow(()-> new ResourceNotFoundException("Categoría no encontrada :: "+ categoriaId));
         return ResponseEntity.ok().body(categoria);
   }*/

   // Vista que muestra el formulario para registrar usuario
	@GetMapping("/ingresarcategoria")
	public ModelAndView createCategoria() {
		ModelAndView mav = new ModelAndView("ingresarcategoria");		
		mav.addObject("categoria", new Categoria());
		return mav;
    }
    
        
    @GetMapping("/addcategoria")
	public @ResponseBody String addUsuario(@ModelAttribute("categoria") Categoria categoria) {
        
        categoriaRepo.save(categoria);					
		return "Categoría " + categoria.getNombreCategoria()+" ingresada con exito";
	}
}