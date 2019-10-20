package com.too.ues.edu.canastabasica.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;
	
	@Column(name = "nombre", nullable = false, length = 100)
	@NotEmpty(message="El nombre es obligatorio")
	private String nombre;

	@Column(name = "correo", nullable = false, length = 100, unique=true)
	@Pattern(regexp="^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9]+(.a-z0-9-]+)*(.[a-z]{2,4})$",message="El correo electrónico ingresado no tiene el formato correcto")	
	private String correo;

	@Column(name = "username", unique = true, nullable = false)
	@Size(min=4,max=45, message="El username tiene que tener entre 4 y 45 caracteres")
	@NotEmpty(message="El username es obligatorio")
	private String username;

	@Column(name = "password", nullable = false)
	//@Size(min=4,max=45, message="La contraseña tiene que tener entre 4 y 45 caracteres")
	@NotEmpty(message="La contraseña es obligatoria")
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "username_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> rol;

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", username="
				+ username + ", password=" + password + ", enabled=" + enabled + "]";
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

	public Long getRolId(){
		Long id=Long.parseLong("0");
		Set<Rol> roles = new HashSet<Rol>();
		roles=getRol();
		for(Rol rol : roles){
			id=rol.getId();	
		}								
		return id;
	}

	public String getRolName(){
		String name="";
		Set<Rol> roles = new HashSet<Rol>();
		roles=getRol();
		for(Rol rol : roles){
			name=rol.getRol();	
		}								
		return name;
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
