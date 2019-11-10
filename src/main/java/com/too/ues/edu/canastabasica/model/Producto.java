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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

import com.too.ues.edu.canastabasica.model.*;

@Entity
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    @Column(name= "idProducto", unique = true , nullable = false)
    private Long idProducto;

    @Column(name="nombreProducto", unique=true,nullable=false, length=200)
    String nombreProducto;

    @Column(name="presentacion", unique=true,nullable=true, length=20)
    String presentacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sub_categoria", nullable = false)
    private SubCategoria subCategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_marca", nullable = false)
    private Marca marca;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="id_medida", referencedColumnName = "idMedida",nullable = false),
        @JoinColumn(name="nombre_medida", referencedColumnName = "nombreMedida",nullable = false),
        @JoinColumn(name="abreviatura", referencedColumnName = "abreviatura",nullable = false)
    })        
    private UnidadMedida unidadMedida;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "producto", orphanRemoval = true)
    private List<RegistroSondeo> registroSondeos;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<RegistroSondeo> getRegistroSondeos() {
        return registroSondeos;
    }

    public void setRegistroSondeos(List<RegistroSondeo> registroSondeos) {
        this.registroSondeos = registroSondeos;
    }

       
}