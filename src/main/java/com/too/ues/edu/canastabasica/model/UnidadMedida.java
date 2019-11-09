package com.too.ues.edu.canastabasica.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.too.ues.edu.canastabasica.model.*;

@Entity
public class UnidadMedida implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -2516019661300555756L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    @Column(name= "idMedida", unique = true , nullable = false)
    private Long idMedida;

    @Id
    @Column(name="nombreMedida", unique=true,nullable=false, length=200)
    String nombreMedida;

    @Id
    @Column(name="abreviatura", unique=true,nullable=false, length=10)
    String abreviatura;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy= "unidadMedida", orphanRemoval=true)
    private List<Producto> productos;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Long idMedida) {
        this.idMedida = idMedida;
    }

    public String getNombreMedida() {
        return nombreMedida;
    }

    public void setNombreMedida(String nombreMedida) {
        this.nombreMedida = nombreMedida;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}