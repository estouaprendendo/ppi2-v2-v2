package com.ppi2.v2.v2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.v2.v2.domain.Locacao;
import com.ppi2.v2.v2.exception.LocacaoAlreadyExistException;
import com.ppi2.v2.v2.exception.LocacaoNotFoundException;
import com.ppi2.v2.v2.repository.LocacaoRepository;

@Service
public class LocacaoService {
	@Autowired
	private LocacaoRepository locacaoRepository;

	@Transactional(readOnly = true)
	public List<Locacao> findAll() {
		return locacaoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Locacao findById(Long id) {
		if (!exist(id)) {
			throw new LocacaoNotFoundException("Locacao com esse id não existe: " + id);
		}
		return locacaoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return locacaoRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Locacao save(Locacao p) {

		if (p.getIdLocacao() != null && exist(p.getIdLocacao())) {
			throw new LocacaoAlreadyExistException("Locacao com esse id já existe: " + p.getIdLocacao());
		}

		return locacaoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Locacao update(Locacao p) {

		if (!exist(p.getIdLocacao())) {
			throw new LocacaoNotFoundException("Locacao com esse id não existe: " + p.getIdLocacao());
		}

		return locacaoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		locacaoRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Locacao p) {
		locacaoRepository.delete(p);
	}

	@Transactional(readOnly = true)
	public List<Locacao> findByMes(Long nmes) {
		return locacaoRepository.findMes(nmes);
	}

}
