package com.too.ues.edu.canastabasica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;


import com.too.ues.edu.canastabasica.model.Producto;

@Repository("ProductoRepo")
public interface ProductoRepo extends JpaRepository<Producto, Long>{

}
