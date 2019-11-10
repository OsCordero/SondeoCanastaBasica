package com.too.ues.edu.canastabasica.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.too.ues.edu.canastabasica.model.*;

import oracle.sql.NUMBER;//TENER CUIDADO
//docs.oracle.com/cd/B19306_01/java.102/b14188/datamap.htm

@Entity
@IdClass(RegistroSondeoId.class)
public class RegistroSondeo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7166766826581845126L;

    @Column(name = "precio", unique = false, nullable = false, length = 6, precision = 2)
    Float precio;

    @Column(name = "peso", unique = false, nullable = false)
    Float peso;

    @Id
    @OneToOne
    @JoinColumn(name="id_producto", nullable=false)    
    private Producto producto;
    
    @Id
    @OneToOne
    @JoinColumn(name="id_periodo", nullable=false)    
    private PeriodoSondeo periodoSondeo;

    @Id
    @OneToOne
    @JoinColumn(name="id_establecimiento",nullable=false)
    private Establecimiento establecimiento;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public PeriodoSondeo getPeriodoSondeo() {
        return periodoSondeo;
    }

    public void setPeriodoSondeo(PeriodoSondeo periodoSondeo) {
        this.periodoSondeo = periodoSondeo;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    
}