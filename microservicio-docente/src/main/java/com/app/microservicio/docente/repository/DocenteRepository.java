package com.app.microservicio.docente.repository;

import org.springframework.data.repository.CrudRepository;

import com.common.entidad.entity.Docente;


public interface DocenteRepository extends CrudRepository<Docente, Long> {

}
