package com.recetario.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetario.repository.CategoriasRepository;
import com.recetario.repository.entities.Categoria;
import com.recetario.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriasRepository repo;

	@Override
	public Optional<Categoria> findByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

}
