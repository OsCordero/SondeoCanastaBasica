package com.too.ues.edu.canastabasica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.too.ues.edu.canastabasica.model.Establecimiento;
import com.too.ues.edu.canastabasica.model.PeriodoSondeo;
import com.too.ues.edu.canastabasica.model.Producto;


//docs.oracle.com/cd/B19306_01/java.102/b14188/datamap.htm

@Entity
@IdClass(RegistroSondeoId.class)
public class RegistroSondeo {
        
    @Column(name = "precio", unique = false, nullable = false, length = 6, precision = 2)
    Float precio;

    @Column(name = "peso", unique = false, nullable = false)
    Float peso;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto", nullable=false)    
    private Producto producto;
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_periodo", nullable=false)    
    private PeriodoSondeo periodoSondeo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_establecimiento",nullable=false)
    private Establecimiento establecimiento;    

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