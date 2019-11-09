package com.too.ues.edu.canastabasica.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;


import com.too.ues.edu.canastabasica.model.Establecimiento;
import com.too.ues.edu.canastabasica.model.Municipio;

@Repository("EstablecimientoRepo")
public interface EstablecimientoRepo extends JpaRepository<Establecimiento, Long>{

    List<Establecimiento> findByMunicipio(Municipio municipio);
}
