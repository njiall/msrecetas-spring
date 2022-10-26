/**
 * 
 */
package com.recetario.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.recetario.repository.entities.Receta;

/**
 * @author Ruben
 *
 */
@SpringBootTest
class RecetaServiceImplTest {
	
	@Autowired
	RecetaService servicio;

	
	@Test
	void listarRecetasTest() {
		Iterable<Receta> respuesta = servicio.listarRecetas();
		assertNotNull(respuesta);		
	}
	
	@Test
	void obtieneRecetaPorNombreTest() {
		Iterable<Receta> respuesta = servicio.obtieneRecetaPorNombre("Pastel");
		assertNotNull(respuesta);		
	}
	
	@Test
	void obtieneRecetaPorIdTest() {
		Optional<Receta> respuesta = servicio.obtieneRecetaPorId(1L);
		assertNotNull(respuesta);		
	}
	
	@Test
	void cargaRecetasTest() {
		List<Receta> recetas = new ArrayList<>();
		Receta rec = new Receta();
		recetas.add(rec);
		boolean respuesta = servicio.cargarRecetas(recetas);
		assertTrue(respuesta);
	}
}
