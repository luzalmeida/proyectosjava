package com.common.entidad.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "docente")
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocente;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	public String getNombre() {
		return nombre;
	}

	public Long getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(Long idDocente) {
		this.idDocente = idDocente;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Docente )) {
			return false;	
		}
		Docente d = (Docente ) obj;
		return this.idDocente != null && this.idDocente.equals(d.getIdDocente());
	
	}
	
	

}
