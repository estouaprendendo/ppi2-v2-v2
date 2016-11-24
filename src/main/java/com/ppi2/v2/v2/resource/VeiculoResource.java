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

import com.ppi2.v2.v2.domain.Locacao;
import com.ppi2.v2.v2.domain.Veiculo;
import com.ppi2.v2.v2.representation.LocacaoRepresentation;
import com.ppi2.v2.v2.representation.VeiculoRepresentation;
import com.ppi2.v2.v2.service.VeiculoService;

@CrossOrigin
@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {
	@Autowired
	private VeiculoService veiculoService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<VeiculoRepresentation>> listAll() {

		List<Veiculo> veiculos = veiculoService.findAll();
		List<VeiculoRepresentation> representation = new ArrayList<>();
		for (Veiculo p : veiculos) {
			representation.add(new VeiculoRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<VeiculoRepresentation> findById(@PathVariable("id") Long id) {

		Veiculo veiculo = veiculoService.findById(id);
		VeiculoRepresentation representation = new VeiculoRepresentation(veiculo);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody VeiculoRepresentation veiculoRepresentation) {

		Veiculo veiculo = veiculoService.save(VeiculoRepresentation.build(veiculoRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getIdVeiculo())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody VeiculoRepresentation representation,
			@PathVariable("id") Long id) {

		representation.setIdentifier(id);
		veiculoService.update(VeiculoRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<VeiculoRepresentation> delete(@PathVariable("id") Long id) {

		Veiculo veiculo = veiculoService.findById(id);
		VeiculoRepresentation representation = new VeiculoRepresentation(veiculo);
		veiculoService.delete(veiculo);
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}/locacaos", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LocacaoRepresentation>> findLocacaoByIdVeiculo(@PathVariable("id") Long id) {
		Veiculo veiculo = veiculoService.findById(id);
		List<Locacao> locacaos = veiculo.getLocacaos();
		List<LocacaoRepresentation> locacaoRepresentation = new ArrayList<>();
		for (Locacao locacao : locacaos) {
			locacaoRepresentation.add(new LocacaoRepresentation(locacao));
		}

		return ResponseEntity.ok(locacaoRepresentation);
	}
}
