package com.recetario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.recetario.repository.entities.Receta;

/**
 * Servicio de recetas.
 * 
 * @author Ruben
 *
 */
public interface RecetaService {

	/**
	 * Recupera un listado completo de recetas paginado
	 * 
	 * @return
	 */
	public Page<Receta> listarRecetas(Pageable pagina);

	/**
	 * Recupera un listado completo de recetas
	 * 
	 * @return
	 */
	public Iterable<Receta> listarRecetas();
	
	/**
	 * Recupera una receta por nombre
	 */
	public Optional<Receta> obtieneRecetaPorId(Long id);

	/**
	 * Recupera una receta por nombre
	 */
	public Iterable<Receta> obtieneRecetaPorNombre(String nombre);

	/**
	 * Recupera una lista de recetas por categoría
	 */

	public Page<Receta> listarRecetasPorCategoria(Pageable pagina);

	/**
	 * Recupera una lista de recetas por ingrediente
	 */
	public Page<Receta> listarRecetasPorIngrediente(Pageable pagina);

	/**
	 * Carga una lista de recetas en BBDD-
	 * 
	 * @param receta
	 * @return
	 */
	public Iterable<Receta> cargarRecetas(List<Receta> receta);

}
