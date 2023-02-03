package com.parnertdigital.msusuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parnertdigital.msusuarios.models.entity.Alumno;
import com.parnertdigital.msusuarios.models.repository.AlumnoRepository;



@Service
public class AlumnoServiceImpl implements AlumnoService {

	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> buscarTodos() {
		return alumnoRepository.findAll();
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> buscarPorId(Long id) {
		return alumnoRepository.findById(id);
	}

	@Override
	@Transactional
	public Alumno guardar(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public void eliminarPorId(Long id) {
		alumnoRepository.deleteById(id);
		
	}

}
