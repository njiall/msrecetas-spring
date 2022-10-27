package com.recetario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recetario.modelo.FiltroBusqueda;
import com.recetario.repository.entities.Receta;
import com.recetario.service.BuscadorService;
import com.recetario.service.RecetaService;

@RestController
@RequestMapping("receta")
public class RecetaController {

	@Autowired
	RecetaService servicio;
	
	@Autowired
	BuscadorService buscador;
	
	@GetMapping
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> listarRecetas() {
		ResponseEntity<?> responseEntity = null;
		Iterable<Receta> listadoRecetas = null;

		listadoRecetas = servicio.listarRecetas();
		responseEntity = ResponseEntity.ok(listadoRecetas);

		return responseEntity;
	}
	
	@GetMapping("detalle/{id}")
	@CrossOrigin(origins = "*")
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
	
	@PostMapping("/buscador")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> buscarRecetas(@RequestBody FiltroBusqueda filtro) {
		ResponseEntity<?> responseEntity = null;
		Iterable<Receta> listadoRecetas = null;

		listadoRecetas = buscador.buscarRecetasTemplate(filtro);
		responseEntity = ResponseEntity.ok(listadoRecetas);

		return responseEntity;
	}
	

	@GetMapping("/{nombre}")
	public ResponseEntity<?> obtieneRecetaPorNombre(@PathVariable String nombre) {
		ResponseEntity<?> responseEntity = null;
		Iterable<Receta> listadoRecetas = null;

		listadoRecetas = servicio.obtieneRecetaPorNombre(nombre);
		responseEntity = ResponseEntity.ok(listadoRecetas);

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
