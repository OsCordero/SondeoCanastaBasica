package com.too.ues.edu.canastabasica.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;

import com.too.ues.edu.canastabasica.model.Producto;
import com.too.ues.edu.canastabasica.model.SubCategoria;

@Repository("ProductoRepo")
public interface ProductoRepo extends JpaRepository<Producto, Serializable>{
	
	List<Producto> findBySubCategoria(SubCategoria subcategoria);

}
