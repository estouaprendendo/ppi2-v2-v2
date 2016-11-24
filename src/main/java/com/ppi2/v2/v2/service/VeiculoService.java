package com.ppi2.v2.v2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.v2.v2.domain.Veiculo;
import com.ppi2.v2.v2.exception.VeiculoAlreadyExistException;
import com.ppi2.v2.v2.exception.VeiculoNotFoundException;
import com.ppi2.v2.v2.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Transactional(readOnly = true)
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Veiculo findById(Long id) {
		if (!exist(id)) {
			throw new VeiculoNotFoundException("Veiculo com esse id não existe: " + id);
		}
		return veiculoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return veiculoRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Veiculo save(Veiculo p) {

		if (p.getIdVeiculo() != null && exist(p.getIdVeiculo())) {
			throw new VeiculoAlreadyExistException("Veiculo com esse id já existe: " + p.getIdVeiculo());
		}

		return veiculoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Veiculo update(Veiculo p) {

		if (!exist(p.getIdVeiculo())) {
			throw new VeiculoNotFoundException("Veiculo com esse id não existe: " + p.getIdVeiculo());
		}

		return veiculoRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		veiculoRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Veiculo p) {
		veiculoRepository.delete(p);
	}
}
