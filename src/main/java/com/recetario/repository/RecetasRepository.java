package com.recetario.repository;

import java.util.Optional;

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
	public Optional<Receta> findByNombreLike(String nombre);
}
