package com.parnertdigital.msusuarios.services;

import org.springframework.stereotype.Service;

import com.parnertdigital.msusuarios.models.entity.Alumno;
import com.parnertdigital.msusuarios.models.repository.AlumnoRepository;

import services.CommonServiceImpl;



@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	
}
