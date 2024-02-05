package com.app.microservicio.colegio.entity;

import java.util.ArrayList;
import java.util.List;

import com.common.entidad.entity.Curso;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name ="colegio")
public class Colegio {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idColegio;
	private String nombre;
	private String direccion;
	private int telefono;
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List <Curso> cursos;
	
	
	public Colegio( ) {
		this.cursos = new ArrayList <>();
	}
	
		public Long getId() {
		return idColegio;
	}
	public void setId(Long id) {
		this.idColegio = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}
	public void removeCurso(Curso curso) {
		this.cursos.remove(curso);
	}
	
	}
