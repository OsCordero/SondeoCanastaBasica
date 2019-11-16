package com.too.ues.edu.canastabasica.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;

import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.model.Producto;
import com.too.ues.edu.canastabasica.model.RegistroSondeo;
import com.too.ues.edu.canastabasica.model.Establecimiento;


@Repository("RegistroSondeoRepo")
public interface RegistroSondeoRepo extends JpaRepository<RegistroSondeo, Serializable>{

	List<RegistroSondeo> findByPeriodoSondeo(PeriodoSondeo periodoSondeo);
	RegistroSondeo findByPeriodoSondeoAndProducto(PeriodoSondeo periodoSondeo, Producto producto);
	RegistroSondeo findByPeriodoSondeoAndEstablecimientoAndProducto(PeriodoSondeo periodoSondeo, Establecimiento establecimiento, Producto producto);
}
