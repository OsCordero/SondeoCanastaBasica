package com.too.ues.edu.canastabasica.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.too.ues.edu.canastabasica.model.*;

@Entity
public class Marca{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    @Column(name= "idMarca", unique = true , nullable = false)
    private Long idMarca;

    @Column(name="nombreMarca", unique=true,nullable=false, length=200)
    String nombreMarca;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy= "marca", orphanRemoval=true)
    private List<Producto> productos;

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}