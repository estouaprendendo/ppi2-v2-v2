package com.ppi2.v2.v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.v2.v2.domain.Categoria;
import com.ppi2.v2.v2.exception.CategoriaAlreadyExistException;
import com.ppi2.v2.v2.exception.CategoriaNotFoundException;
import com.ppi2.v2.v2.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Categoria findById(Long id) {
		if (!exist(id)) {
			throw new CategoriaNotFoundException("Categoria com esse id não existe: " + id);
		}
		return categoriaRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return categoriaRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Categoria save(Categoria p) {

		if (p.getIdCategoria() != null && exist(p.getIdCategoria())) {
			throw new CategoriaAlreadyExistException("Categoria com esse id já existe: " + p.getIdCategoria());
		}

		return categoriaRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Categoria update(Categoria p) {

		if (!exist(p.getIdCategoria())) {
			throw new CategoriaNotFoundException("Categoria com esse id não existe: " + p.getIdCategoria());
		}

		return categoriaRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		categoriaRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Categoria p) {
		categoriaRepository.delete(p);
	}
}
