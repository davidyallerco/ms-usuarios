package com.parnertdigital.msusuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parnertdigital.msusuarios.models.entity.Alumno;
import com.parnertdigital.msusuarios.services.AlumnoService;

@RestController
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping
	public ResponseEntity<?> listar() {//el ResponseEntity es un objeto que nos permite construir una respuesta
		return ResponseEntity.ok().body(alumnoService.buscarTodos());//pasamos al body el resultado de alumnoService...
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Alumno> optional = alumnoService.buscarPorId(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno){//como viene del cuerpo del request se pone @RequesBody
		Alumno alumnoDb = alumnoService.guardar(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Alumno> optional = alumnoService.buscarPorId(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumnoDb = optional.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		//La fecha no va, el sistema lo maneja por debajo
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.guardar(alumnoDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		alumnoService.eliminarPorId(id);
		return ResponseEntity.noContent().build();
	}

}
