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

import com.ppi2.v2.v2.domain.Avaria;
import com.ppi2.v2.v2.domain.Cliente;
import com.ppi2.v2.v2.domain.Locacao;
import com.ppi2.v2.v2.domain.Multa;
import com.ppi2.v2.v2.representation.AvariaRepresentation;
import com.ppi2.v2.v2.representation.ClienteRepresentation;
import com.ppi2.v2.v2.representation.LocacaoRepresentation;
import com.ppi2.v2.v2.representation.MultaRepresentation;
import com.ppi2.v2.v2.service.ClienteService;
import com.ppi2.v2.v2.service.LocacaoService;

@CrossOrigin
@RestController
@RequestMapping("/locacoes")
public class LocacaoResource {
	@Autowired
	private LocacaoService locacaoService;
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LocacaoRepresentation>> listAll() {

		List<Locacao> locacoes = locacaoService.findAll();
		List<LocacaoRepresentation> representation = new ArrayList<>();
		for (Locacao p : locacoes) {
			representation.add(new LocacaoRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{idLocacao}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<LocacaoRepresentation> findById(@PathVariable("idLocacao") Long id) {

		Locacao locacao = locacaoService.findById(id);
		LocacaoRepresentation representation = new LocacaoRepresentation(locacao);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody LocacaoRepresentation representation) {

		Locacao locacao = locacaoService.save(LocacaoRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idLocacao}")
				.buildAndExpand(locacao.getIdLocacao()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{idLocacao}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody LocacaoRepresentation representation,
			@PathVariable("idLocacao") Long id) {

		representation.setIdentifier(id);
		locacaoService.update(LocacaoRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<LocacaoRepresentation> delete(@PathVariable("id") Long id) {

		Locacao locacao = locacaoService.findById(id);
		LocacaoRepresentation representation = new LocacaoRepresentation(locacao);
		locacaoService.delete(locacao);
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}/multas", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<MultaRepresentation>> findMultasByIdLocacao(@PathVariable("id") Long id) {

		Locacao locacao = locacaoService.findById(id);

		List<Multa> multas = locacao.getMultas();
		List<MultaRepresentation> representation = new ArrayList<>();
		for (Multa multa : multas) {
			representation.add(new MultaRepresentation(multa));
		}
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}/avarias", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<AvariaRepresentation>> findAvariasByIdLocacao(@PathVariable("id") Long id) {

		Locacao locacao = locacaoService.findById(id);

		List<Avaria> avarias = locacao.getAvarias();
		List<AvariaRepresentation> representation = new ArrayList<>();
		for (Avaria avaria : avarias) {
			representation.add(new AvariaRepresentation(avaria));
		}
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/mes/{nmes}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LocacaoRepresentation>> findLocacaosByMes(@PathVariable("nmes") Long nmes) {

		List<Locacao> locacoes = locacaoService.findByMes(nmes);

		List<LocacaoRepresentation> representation = new ArrayList<>();
		for (Locacao locacao : locacoes) {
			representation.add(new LocacaoRepresentation(locacao));
		}
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/clientes_do_mes/{nmes}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<ClienteRepresentation>> findClienteDoMes(@PathVariable("nmes") Long nmes) {

		List<Cliente> clientes = clienteService.findClienteMaxLocationMonth(nmes);

		List<ClienteRepresentation> representation = new ArrayList<>();
		for (Cliente cliente : clientes) {
			representation.add(new ClienteRepresentation(cliente));
		}

		return ResponseEntity.ok(representation);
	}
}
