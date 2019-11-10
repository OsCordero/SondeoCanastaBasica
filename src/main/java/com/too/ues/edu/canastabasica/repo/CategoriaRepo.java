package com.too.ues.edu.canastabasica.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.too.ues.edu.canastabasica.model.Categoria;

@Repository("CategoriaRepo")
public interface CategoriaRepo extends JpaRepository<Categoria, Serializable>{
    
}