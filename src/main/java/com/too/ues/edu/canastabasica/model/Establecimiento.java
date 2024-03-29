package com.too.ues.edu.canastabasica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.too.ues.edu.canastabasica.model.Municipio;
import com.too.ues.edu.canastabasica.model.RegistroSondeo;

@Entity
public class Establecimiento{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idEstablecimiento", unique = true, nullable = false)
    private Long idEstablecimiento;

    @Column(name = "nombreEstablecimiento", unique = true, nullable = false, length = 200)
    String nombreEstablecimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "establecimiento", orphanRemoval = true)
    private List<RegistroSondeo> registroSondeos;

    public Long getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Long idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<RegistroSondeo> getRegistroSondeos() {
        return registroSondeos;
    }

    public void setRegistroSondeos(List<RegistroSondeo> registroSondeos) {
        this.registroSondeos = registroSondeos;
    }

       
}