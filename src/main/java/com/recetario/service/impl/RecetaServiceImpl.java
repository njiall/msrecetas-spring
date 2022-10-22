package com.recetario.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.recetario.repository.RecetasRepository;
import com.recetario.repository.entities.Receta;
import com.recetario.service.RecetaService;

@Service
public class RecetaServiceImpl implements RecetaService {

	@Autowired
	RecetasRepository repo;

	@Override
	public Iterable<Receta> listarRecetas() {
		return repo.findAll();
	}

	@Override
	public Page<Receta> listarRecetas(Pageable pagina) {
		return repo.findAll(pagina);
	}

	@Override
	public Optional<Receta> obtieneRecetaPorNombre(String nombre) {
		return repo.findByNombreLike("%"+nombre+"%");
	}

	@Override
	public Page<Receta> listarRecetasPorCategoria(Pageable pagina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Receta> listarRecetasPorIngrediente(Pageable pagina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean cargarRecetas(List<Receta> receta) {
		boolean respuesta = true;

		try {
			receta.forEach(a -> repo.save(a));
		} catch (Exception e) {
			respuesta = false;
			throw e;
		}

		return respuesta;
	}

	@Override
	public Optional<Receta> obtieneRecetaPorId(Long id) {
		return repo.findById(id);
	}

}
