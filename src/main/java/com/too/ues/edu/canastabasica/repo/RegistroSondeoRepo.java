package com.too.ues.edu.canastabasica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;


import com.too.ues.edu.canastabasica.model.RegistroSondeo;

@Repository("RegistroSondeoRepo")
public interface RegistroSondeoRepo extends JpaRepository<RegistroSondeo, Long>{

}
