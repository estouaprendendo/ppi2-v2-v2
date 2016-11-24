package com.ppi2.v2.v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.v2.v2.domain.Avaria;
import com.ppi2.v2.v2.exception.AvariaAlreadyExistException;
import com.ppi2.v2.v2.exception.AvariaNotFoundException;
import com.ppi2.v2.v2.repository.AvariaRepository;

@Service
public class AvariaService {
	@Autowired
	private AvariaRepository avariaRepository;

	@Transactional(readOnly = true)
	public List<Avaria> findAll() {
		return avariaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Avaria findById(Long idAvaria) {
		if (!exist(idAvaria)) {
			throw new AvariaNotFoundException("Avaria com esse id não existe: " + idAvaria);
		}
		return avariaRepository.findOne(idAvaria);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long idAvaria) {
		return avariaRepository.exists(idAvaria);
	}

	@Transactional(readOnly = false)
	public Avaria save(Avaria p) {

		if (p.getIdAvaria() != null && exist(p.getIdAvaria())) {
			throw new AvariaAlreadyExistException("Avaria com esse id já existe: " + p.getIdAvaria());
		}

		return avariaRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Avaria update(Avaria p) {

		if (!exist(p.getIdAvaria())) {
			throw new AvariaNotFoundException("Avaria com esse id não existe: " + p.getIdAvaria());
		}

		return avariaRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		avariaRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Avaria p) {
		avariaRepository.delete(p);
	}
}
