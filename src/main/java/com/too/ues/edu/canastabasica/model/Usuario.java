package com.too.ues.edu.canastabasica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.too.ues.edu.canastabasica.model.Rol;

@Entity
public class Usuario {
		
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue
	private Long idUsuario;

	@Column(name= "nombre", nullable = false,length = 100)
	private String nombre;
	
	@Column(name= "correo", nullable = false,length = 100)
	private String correo; 
	
	@Column(name= "username", unique = true , nullable = false,length = 45)
	private String username;

	@Column(name= "password", nullable = false,length = 60)
	private String password;

	@Column(name= "enabled",nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="roles_usuarios",
	joinColumns=@JoinColumn(name="username_id"),
	inverseJoinColumns=@JoinColumn(name="rol_id"))
	private Set<Rol> rol;
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 :idUsuario.hashCode());
		return result;
	}	

	@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Usuario other = (Usuario) obj;
    if (idUsuario == null) {
        if (other.idUsuario != null)
            return false;
        } else if (!idUsuario.equals(other.idUsuario))
            return false;
        return true;
}

@Override
public String toString() {
	return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", username=" + username
			+ ", password=" + password + ", enabled=" + enabled + "]";
}
	public Long getIdUsuario() {
		return idUsuario;
	}

		public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
