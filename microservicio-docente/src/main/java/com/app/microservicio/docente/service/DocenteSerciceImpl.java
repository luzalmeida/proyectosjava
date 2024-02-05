package com.app.microservicio.docente.service;

import org.springframework.stereotype.Service;

import com.app.microservicio.docente.repository.DocenteRepository;
import com.common.entidad.entity.Docente;
import com.common.microservicio.service.CommonServiceImpl;



@Service
public class DocenteSerciceImpl extends CommonServiceImpl<Docente, DocenteRepository> implements DocenteService {

	
}
