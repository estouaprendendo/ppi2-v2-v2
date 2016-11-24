package com.ppi2.v2.v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.v2.v2.domain.Funcionario;
import com.ppi2.v2.v2.exception.FuncionarioAlreadyExistException;
import com.ppi2.v2.v2.exception.FuncionarioNotFoundException;
import com.ppi2.v2.v2.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Transactional(readOnly = true)
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Funcionario findById(Long id) {
		if (!exist(id)) {
			throw new FuncionarioNotFoundException("Funcionario com esse id não existe: " + id);
		}
		return funcionarioRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return funcionarioRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Funcionario save(Funcionario p) {

		if (p.getIdFuncionario() != null && exist(p.getIdFuncionario())) {
			throw new FuncionarioAlreadyExistException("Funcionario com esse id já existe: " + p.getIdFuncionario());
		}

		return funcionarioRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Funcionario update(Funcionario p) {

		if (!exist(p.getIdFuncionario())) {
			throw new FuncionarioNotFoundException("Funcionario com esse id não existe: " + p.getIdFuncionario());
		}

		return funcionarioRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		funcionarioRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Funcionario p) {
		funcionarioRepository.delete(p);
	}
}
