package com.too.ues.edu.canastabasica.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;


import com.too.ues.edu.canastabasica.model.Municipio;
import com.too.ues.edu.canastabasica.model.Departamento;

@Repository("MunicipioRepo")
public interface MunicipioRepo extends JpaRepository<Municipio, Long>{

    List<Municipio> findByDepartamento(Departamento departamento);
}
