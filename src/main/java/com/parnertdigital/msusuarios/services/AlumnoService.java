package com.parnertdigital.msusuarios.services;

import java.util.Optional;

import com.parnertdigital.msusuarios.models.entity.Alumno;

public interface AlumnoService {

	public Iterable<Alumno> buscarTodos();
	public Optional<Alumno> buscarPorId(Long id);
	public Alumno guardar(Alumno alumno);
	public void eliminarPorId(Long id);
}
