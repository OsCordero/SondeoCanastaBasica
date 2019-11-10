package com.too.ues.edu.canastabasica.repo;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.too.ues.edu.canastabasica.model.SubCategoria;
import com.too.ues.edu.canastabasica.model.Categoria;

@Repository("SubCategoriaRepo")
public interface SubCategoriaRepo extends JpaRepository<SubCategoria, Serializable>{
    //List<SubCategoria> findByIdCategoria(Long idCategoria);
    List<SubCategoria> findByCategoria(Categoria categoria);
    //Optional<SubCategoria> findByIdAndCategoriaId(Long id, Long categoriaId);
}