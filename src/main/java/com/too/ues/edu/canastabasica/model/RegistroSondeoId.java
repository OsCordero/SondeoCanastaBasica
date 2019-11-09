package com.too.ues.edu.canastabasica.model;

import java.io.Serializable;

//docs.oracle.com/cd/B19306_01/java.102/b14188/datamap.htm

public class RegistroSondeoId implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 334787886591551790L;

    private Long producto;
    private Long periodoSondeo;
    private Long establecimiento;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public Long getPeriodoSondeo() {
        return periodoSondeo;
    }

    public void setPeriodoSondeo(Long periodoSondeo) {
        this.periodoSondeo = periodoSondeo;
    }

    public Long getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Long establecimiento) {
        this.establecimiento = establecimiento;
    }

    
    }
