package com.too.ues.edu.canastabasica.servicio;

import java.util.List;

import com.too.ues.edu.canastabasica.model.Producto;
import com.too.ues.edu.canastabasica.model.SubCategoria;

public interface ProductoService {
	
	public abstract List<Producto> listAllProducto();
	public abstract List<Producto> listAllProductosBySubCategoria(SubCategoria subcategoria);
	public abstract Producto addProducto(Producto producto);
	public abstract int deleteProducto(Long id);
	public abstract Producto updateProducto(Producto producto);
	public abstract Producto findProductoById(Long id);	
}
