package com.recetario.service;

import com.recetario.modelo.FiltroBusqueda;
import com.recetario.repository.entities.Receta;


public interface BuscadorService {

	/**
	 * Buscador dinámico de recetas usando criteria
	 * 
	 * @param filtro Parámetros de búsqueda
	 * @return resultado de la búsqueda
	 */
	public Iterable<Receta> buscarRecetasCriteria(FiltroBusqueda filtro);

	/**
	 * Buscador dinámico de recetas usando JdbcTemplate
	 * 
	 * @param filtro Parámetros de búsqueda
	 * @return resultado de la búsqueda
	 */
	public Iterable<Receta> buscarRecetasTemplate(FiltroBusqueda filtro);

}
