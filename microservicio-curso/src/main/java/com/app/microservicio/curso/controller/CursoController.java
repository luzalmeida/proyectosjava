package com.app.microservicio.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservicio.curso.service.CursoService;
import com.common.microservicio.controller.CommonController;
import com.common.entidad.entity.Alumno;
import com.common.entidad.entity.Asignatura;
import com.common.entidad.entity.Curso;


@RestController
@RequestMapping("/api/curso")
public class CursoController extends CommonController <Curso, CursoService>{

	
	@PutMapping ("/actualizar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Curso curso){
		Optional <Curso> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Curso cursoDb = o.get();
		cursoDb.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	@PutMapping ("/{id}/asignar-asignaturas")
	public ResponseEntity <?> asignarAsignaturas (@RequestBody List <Asignatura> asignaturas , @PathVariable Long id ){
		Optional <Curso> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Curso cursoDb = o.get();
		asignaturas.forEach(a ->{
			System.out.println(a);
			cursoDb.addAsignatura(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	@PutMapping ("/{id}/eliminar-asignatura")
	public ResponseEntity <?> eliminarAsignaturas (@RequestBody Asignatura asignatura, @PathVariable Long id ){
		Optional <Curso> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Curso cursoDb = o.get();
		cursoDb.removeAsignatura(asignatura);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}

	@PutMapping ("/{id}/asignar-alumnos")
	public ResponseEntity <?> asignarAlumnos (@RequestBody List <Alumno> alumnos , @PathVariable Long id ){
		Optional <Curso> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Curso cursoDb = o.get();
		alumnos.forEach(a ->{
			System.out.println(a);
			cursoDb.addAlumno(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}
	
	@PutMapping ("/{id}/eliminar-alumno")
	public ResponseEntity <?> eliminarAlumnos (@RequestBody Alumno alumno , @PathVariable Long id ){
		Optional <Curso> o = service.findById(id);
		if (!o.isPresent()) {
			ResponseEntity.notFound().build();	
		}
		Curso cursoDb = o.get();
		cursoDb.removeAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
	}


}
