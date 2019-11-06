package com.too.ues.edu.canastabasica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.too.ues.edu.canastabasica.model.*;

import oracle.sql.DATE;//EXISTEN OTROS TIPOS DATE, HAY QUE TENER CUIDADO
//docs.oracle.com/cd/B19306_01/java.102/b14188/datamap.htm

@Entity
public class PeriodoSondeo{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idPeriodo", unique = true, nullable = false)
    private Long idPeriodo;

    @Column(name = "nombrePeriodo", unique = true, nullable = false, length = 200)
    String nombrePeriodo;

    @Column(name = "fechaInicio", unique = true, nullable = false)
    DATE fechaInicio;

    @Column(name = "fechaFin", unique = true, nullable = false)
    DATE fechaFin;

    @Column(name = "finalizado", nullable = true)
    private boolean finalizado;

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public DATE getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(DATE fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public DATE getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(DATE fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    
}