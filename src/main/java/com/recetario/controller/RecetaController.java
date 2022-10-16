package com.recetario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recetario.repository.entities.Receta;
import com.recetario.service.RecetaService;

@RestController
@RequestMapping("receta")
public class RecetaController {

	@Autowired
	RecetaService servicio;

	@GetMapping
	public ResponseEntity<?> listarRecetas() {
		ResponseEntity<?> responseEntity = null;
		Iterable<Receta> listadoCursos = null;

		listadoCursos = servicio.listarRecetas();
		responseEntity = ResponseEntity.ok(listadoCursos);

		return responseEntity;
	}

	@GetMapping("/{nombre}")
	public ResponseEntity<?> obtieneRecetaPorNombre(@PathVariable String nombre) {
		ResponseEntity<?> responseEntity = null;
		Optional<Receta> optional;
//TODO Tener el cuenta mayusculas/minusculas
		optional = servicio.obtieneRecetaPorNombre(nombre);
		if (optional.isPresent()) {
			Receta recetaLeida = optional.get();
			responseEntity = ResponseEntity.ok(recetaLeida);
		} else {
			responseEntity = ResponseEntity.noContent().build();// 204
		}

		return responseEntity;
	}

	@PostMapping("/cargarRecetas")
	public ResponseEntity<?> cargarRecetas(@RequestBody List<Receta> recetas) {
		ResponseEntity<?> responseEntity = null;
		boolean respuestaOk = false;

		respuestaOk = servicio.cargarRecetas(recetas);
		if (respuestaOk) {

			responseEntity = ResponseEntity.ok("Se han cargado correctamente las recetas");
		} else {
			responseEntity = ResponseEntity.notFound().build();// 404/
		}

		return responseEntity;
	}

}
