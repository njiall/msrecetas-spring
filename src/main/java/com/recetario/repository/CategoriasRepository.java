package com.recetario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.recetario.repository.entities.Categoria;

public interface CategoriasRepository extends CrudRepository<Categoria, Long>{
	
	/**
	 * Recupera una categoría por su nombre.
	 * 
	 * @param nombre
	 * @return
	 */
	public Optional<Categoria> findByNombre(String nombre);

}
