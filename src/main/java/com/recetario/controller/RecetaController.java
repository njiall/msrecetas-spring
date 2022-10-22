package com.recetario.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.recetario.repository.entities.Receta;
import com.recetario.service.RecetaService;

@RestController
@RequestMapping("receta")
public class RecetaController {

	@Autowired
	RecetaService servicio;
	
	@Autowired
	ObjectMapper om;//mapeador JSON

	@GetMapping
	public ResponseEntity<?> listarRecetas() {
		ResponseEntity<?> responseEntity = null;
		Iterable<Receta> listadoCursos = null;

		listadoCursos = servicio.listarRecetas();
		responseEntity = ResponseEntity.ok(listadoCursos);

		return responseEntity;
	}
	
	@GetMapping("detalle/{id}")
	public ResponseEntity<?> obtieneDetalleReceta(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Optional<Receta> optional;
		optional = servicio.obtieneRecetaPorId(id);
		if (optional.isPresent()) {
			Receta recetaLeida = optional.get();
			responseEntity = ResponseEntity.ok(recetaLeida);
		} else {
			responseEntity = ResponseEntity.noContent().build();// 204
		}

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
