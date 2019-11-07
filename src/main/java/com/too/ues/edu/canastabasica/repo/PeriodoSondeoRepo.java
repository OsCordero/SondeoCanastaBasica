package com.too.ues.edu.canastabasica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import com.too.ues.edu.canastabasica.model.PeriodoSondeo;

@Repository("PeriodoSondeoRepo")
public interface PeriodoSondeoRepo extends JpaRepository<PeriodoSondeo, Long>{

}
