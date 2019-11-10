package com.too.ues.edu.canastabasica.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;


import com.too.ues.edu.canastabasica.model.Departamento;

@Repository("DepartamentoRepo")
public interface DepartamentoRepo extends JpaRepository<Departamento, Serializable>{

}
