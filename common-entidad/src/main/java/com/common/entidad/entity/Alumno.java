package com.common.entidad.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlumno;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	
	
	public String getNombre() {
		return nombre;
	}
	
	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
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
		if (!(obj instanceof Alumno )) {
			return false;	
		}
		Alumno a = (Alumno ) obj;
		return this.idAlumno != null && this.idAlumno.equals(a.getIdAlumno());
	
	}
	
	

}
