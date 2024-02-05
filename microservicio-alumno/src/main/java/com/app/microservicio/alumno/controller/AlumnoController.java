package com.app.microservicio.alumno.controller;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.microservicio.alumno.service.AlumnoService;
import com.common.entidad.entity.Alumno;
import com.common.microservicio.controller.CommonController;



@RestController
@RequestMapping("/api/alumno")
public class AlumnoController extends CommonController <Alumno, AlumnoService>{
	
	@PutMapping ("/actualizar/{id}")
	public ResponseEntity <?> editar (@PathVariable Long id, @RequestBody Alumno alumno){
		Optional <Alumno> o = service.findById(id);
		if (o.isEmpty()) {
			ResponseEntity.notFound().build();	
		}
		Alumno alumnoDb = o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		alumnoDb.setContrasena(alumno.getContrasena());	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	@GetMapping ("/filtrar/{term}")
		public ResponseEntity<?> filtrar (@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}
	
}