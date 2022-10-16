package com.recetario.service;

import java.util.Optional;

import com.recetario.repository.entities.Categoria;

public interface CategoriaService {
	
	/**
	 * Recupera una categoría por su nombre.
	 * 
	 * @param nombre
	 * @return
	 */
	public Optional<Categoria> findByNombre(String nombre);

}
