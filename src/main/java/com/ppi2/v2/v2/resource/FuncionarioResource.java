package com.ppi2.v2.v2.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ppi2.v2.v2.domain.Funcionario;
import com.ppi2.v2.v2.domain.Locacao;
import com.ppi2.v2.v2.representation.FuncionarioRepresentation;
import com.ppi2.v2.v2.representation.LocacaoRepresentation;
import com.ppi2.v2.v2.service.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {
	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<FuncionarioRepresentation>> listAll() {

		List<Funcionario> funcionarios = funcionarioService.findAll();
		List<FuncionarioRepresentation> representation = new ArrayList<>();
		for (Funcionario p : funcionarios) {
			representation.add(new FuncionarioRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<FuncionarioRepresentation> findById(@PathVariable("id") Long id) {

		Funcionario funcionario = funcionarioService.findById(id);
		FuncionarioRepresentation representation = new FuncionarioRepresentation(funcionario);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody FuncionarioRepresentation representation) {

		Funcionario funcionario = funcionarioService.save(FuncionarioRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(funcionario.getIdFuncionario()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody FuncionarioRepresentation representation,
			@PathVariable("id") Long id) {

		representation.setIdentifier(id);
		funcionarioService.update(FuncionarioRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<FuncionarioRepresentation> delete(@PathVariable("id") Long id) {

		Funcionario funcionario = funcionarioService.findById(id);
		FuncionarioRepresentation representation = new FuncionarioRepresentation(funcionario);
		funcionarioService.delete(funcionario);
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}/locacaos_cad", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LocacaoRepresentation>> findLocacaoByIdFuncionario(
			@PathVariable("id") Long id) {
		Funcionario funcionario = funcionarioService.findById(id);
		List<Locacao> locacaos = funcionario.getLocacaosCad();
		List<LocacaoRepresentation> locacaoRepresentation = new ArrayList<>();
		for (Locacao locacao : locacaos) {
			locacaoRepresentation.add(new LocacaoRepresentation(locacao));
		}

		return ResponseEntity.ok(locacaoRepresentation);
	}

	@RequestMapping(value = "/{id}/locacaos_rec", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LocacaoRepresentation>> findLocacaoByIdFuncionarioRec(
			@PathVariable("id") Long id) {

		Funcionario funcionario = funcionarioService.findById(id);
		List<Locacao> locacaos = funcionario.getLocacaosRec();

		List<LocacaoRepresentation> locacaoRepresentation = new ArrayList<>();
		for (Locacao locacao : locacaos) {
			locacaoRepresentation.add(new LocacaoRepresentation(locacao));
		}

		return ResponseEntity.ok(locacaoRepresentation);
	}

}
