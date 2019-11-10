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

import com.too.ues.edu.canastabasica.model.SubCategoria;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)    
    @Column(name= "idCategoria", unique = true , nullable = false)
	private Long idCategoria;

	@Column(name= "nombreCategoria", unique = true , nullable = false,length = 50)
    private String nombreCategoria;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy= "categoria", orphanRemoval=true)
    private List<SubCategoria> subCategorias;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    public String getSubCategoriasToString(){
        String cadena="";        
        List<SubCategoria> subCategorias=getSubCategorias();        
        for(SubCategoria subCategoria:subCategorias){
            cadena=cadena+subCategoria.getNombreSubCategoria();
            if(subCategorias.size()>1){
                cadena=cadena+", ";
            }            
        }
                
        if(cadena.endsWith(" ")){
            cadena=cadena.substring(0,cadena.length()-2);
        }
        return cadena;
    }

    public void setSubCategorias(List<SubCategoria> subCategorias) {
        this.subCategorias = subCategorias;
    }        
}