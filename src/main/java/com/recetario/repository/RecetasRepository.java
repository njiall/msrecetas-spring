package com.recetario.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.recetario.repository.entities.Receta;
/**
 * Repositorio de recetas
 * 
 * @author Ruben
 *
 */
public interface RecetasRepository extends PagingAndSortingRepository<Receta, Long>{

	/**
	 * Recupera una receta por su nombre.
	 * 
	 * @param nombre Nombre de la receta
	 * @return Receta devuelta
	 */
	public Iterable<Receta> findByNombreLike(String nombre);
	
	/**
	 * Recupera el listado de recetas ordenado por nombre
	 * 
	 * @return
	 */
	public Iterable<Receta> findAllByOrderByNombre();
}
