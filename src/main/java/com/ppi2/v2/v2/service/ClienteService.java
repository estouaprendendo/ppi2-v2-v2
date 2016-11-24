package com.ppi2.v2.v2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppi2.v2.v2.domain.Cliente;
import com.ppi2.v2.v2.exception.ClienteAlreadyExistException;
import com.ppi2.v2.v2.exception.ClienteNotFoundException;
import com.ppi2.v2.v2.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		if (!exist(id)) {
			throw new ClienteNotFoundException("Cliente com esse id não existe: " + id);
		}
		return clienteRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public boolean exist(Long id) {
		return clienteRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Cliente save(Cliente p) {

		if (p.getIdCliente() != null && exist(p.getIdCliente())) {
			throw new ClienteAlreadyExistException("Cliente com esse id já existe: " + p.getIdCliente());
		}

		return clienteRepository.save(p);
	}

	@Transactional(readOnly = false)
	public Cliente update(Cliente p) {

		if (!exist(p.getIdCliente())) {
			throw new ClienteNotFoundException("Cliente com esse id não existe: " + p.getIdCliente());
		}

		return clienteRepository.save(p);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		clienteRepository.delete(id);
	}

	@Transactional(readOnly = false)
	public void delete(Cliente p) {
		clienteRepository.delete(p);
	}

	@Transactional(readOnly = true)
	public List<Cliente> findClienteMaxLocationMonth(Long nmes) {
		return clienteRepository.findClienteMaxLocationMonth(nmes);
	}

	@Transactional(readOnly = true)
	public Cliente findByCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
}
