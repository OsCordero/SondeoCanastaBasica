package com.too.ues.edu.canastabasica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.too.ues.edu.canastabasica.model.Producto;
import com.too.ues.edu.canastabasica.repo.ProductoRepo;
import com.too.ues.edu.canastabasica.servicio.ProductoService;

@Service("productoServiceImpl")
public class ProductoImpl implements ProductoService {

	@Autowired
	@Qualifier("ProductoRepo")
	private ProductoRepo productoRepo;
	
	@Override
	public List<Producto> listAllProducto() {
		return productoRepo.findAll();
	}

	@Override
	public Producto addProducto(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public int deleteProducto(Long id) {
		Producto producto = this.findProductoById(id);		
        productoRepo.delete(producto);
        //otra manera 
        //productoRepo.deleteById(id);
		return 0;
	}

	@Override
	public Producto updateProducto(Producto producto) {
		productoRepo.save(producto);
		return null;
	}

	@Override
	public Producto findProductoById(Long id) {
		return productoRepo.getOne(id);
	}
	
}