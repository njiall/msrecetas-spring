package com.recetario.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.recetario.modelo.FiltroBusqueda;
import com.recetario.repository.entities.Receta;

@SpringBootTest
class BuscadorServiceImplTest {
	
	@Autowired
	BuscadorService servicio;

	@Test
	void testCriteriaListado() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		Iterable<Receta> respuesta = servicio.buscarRecetasCriteria(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testTemplateListado() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		Iterable<Receta> respuesta = servicio.buscarRecetasTemplate(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testCriteriaFiltroNombre() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setNombre("Pastel");
		Iterable<Receta> respuesta = servicio.buscarRecetasCriteria(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testCriteriaFiltroCategoria() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setNombre("Principal");
		Iterable<Receta> respuesta = servicio.buscarRecetasCriteria(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testCriteriaFiltroEtiquetas() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setEtiquetas("Pescado, Carne");
		Iterable<Receta> respuesta = servicio.buscarRecetasCriteria(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testCriteriaFiltroFechaHasta() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setFechaDesde(new Date());
		Iterable<Receta> respuesta = servicio.buscarRecetasCriteria(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testCriteriaFiltroFechaDesde() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		String sDate1="31/12/1998";  
	    try {
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			filtro.setFechaDesde(date1);
			Iterable<Receta> respuesta = servicio.buscarRecetasCriteria(filtro);
			assertNotNull(respuesta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
	@Test
	void testTemplateFiltroNombre() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setNombre("Pastel");
		Iterable<Receta> respuesta = servicio.buscarRecetasTemplate(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testTemplateFiltroCategoria() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setNombre("Principal");
		Iterable<Receta> respuesta = servicio.buscarRecetasTemplate(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testTemplateFiltroEtiquetas() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setEtiquetas("Pescado, Carne");
		Iterable<Receta> respuesta = servicio.buscarRecetasTemplate(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testTemplateFiltroFechaHasta() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		filtro.setFechaDesde(new Date());
		Iterable<Receta> respuesta = servicio.buscarRecetasTemplate(filtro);
		assertNotNull(respuesta);
	}
	
	@Test
	void testTemplateFiltroFechaDesde() {
		FiltroBusqueda filtro = new FiltroBusqueda();
		String sDate1="31/12/1998";  
	    try {
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			filtro.setFechaDesde(date1);
			Iterable<Receta> respuesta = servicio.buscarRecetasTemplate(filtro);
			assertNotNull(respuesta);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
