package com.too.ues.edu.canastabasica.model;

import java.util.List;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.too.ues.edu.canastabasica.model.RegistroSondeo;

//import oracle.sql.Date;//EXISTEN OTROS TIPOS Date, HAY QUE TENER CUIDADO
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
    Date fechaInicio;
    
    @Column(name = "fechaFin", unique = true, nullable = false)
    Date fechaFin;

    @Column(name = "finalizado", nullable = true)
    private boolean finalizado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "periodoSondeo", orphanRemoval = true)
    private List<RegistroSondeo> registroSondeos;

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    
}