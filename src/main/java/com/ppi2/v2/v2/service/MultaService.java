package com.ppi2.v2.v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.v2.v2.domain.Multa;
import com.ppi2.v2.v2.exception.MultaAlreadyExistException;
import com.ppi2.v2.v2.exception.MultaNotFoundException;
import com.ppi2.v2.v2.repository.MultaRepository;

@Service
public class MultaService {
	@Autowired
	private MultaRepository multaRepository;

	@Transactional(readOnly = true)
	public List<Multa> findAll() {
		return multaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Multa findById(Long id) {
		if (!exist(id)) {
			throw new MultaNotFoundException("Multa com esse id não existe: " + id);
		}
		return multaRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return multaRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Multa save(Multa p) {

		if (p.getIdMulta() != null && exist(p.getIdMulta())) {
			throw new MultaAlreadyExistException("Multa com esse id já existe: " + p.getIdMulta());
		}

		return multaRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Multa update(Multa p) {

		if (!exist(p.getIdMulta())) {
			throw new MultaNotFoundException("Multa com esse id não existe: " + p.getIdMulta());
		}

		return multaRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		multaRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Multa p) {
		multaRepository.delete(p);
	}
}
