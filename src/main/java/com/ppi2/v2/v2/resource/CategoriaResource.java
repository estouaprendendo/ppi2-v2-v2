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

import com.ppi2.v2.v2.domain.Categoria;
import com.ppi2.v2.v2.domain.Veiculo;
import com.ppi2.v2.v2.representation.CategoriaRepresentation;
import com.ppi2.v2.v2.representation.VeiculoRepresentation;
import com.ppi2.v2.v2.service.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<CategoriaRepresentation>> listAll() {

		List<Categoria> categorias = categoriaService.findAll();
		List<CategoriaRepresentation> representation = new ArrayList<>();
		for (Categoria p : categorias) {
			representation.add(new CategoriaRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<CategoriaRepresentation> findById(@PathVariable("id") Long id) {

		Categoria categoria = categoriaService.findById(id);
		CategoriaRepresentation representation = new CategoriaRepresentation(categoria);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody CategoriaRepresentation representation) {

		Categoria categoria = categoriaService.save(CategoriaRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoria.getIdCategoria()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody CategoriaRepresentation representation,
			@PathVariable("id") Long id) {

		representation.setIdentifier(id);
		categoriaService.update(CategoriaRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<CategoriaRepresentation> delete(@PathVariable("id") Long id) {

		Categoria categoria = categoriaService.findById(id);
		CategoriaRepresentation representation = new CategoriaRepresentation(categoria);
		categoriaService.delete(categoria);
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}/veiculos", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<VeiculoRepresentation>> findVeiculoByIdCategoria(@PathVariable("id") Long id) {
		Categoria categoria = categoriaService.findById(id);
		List<Veiculo> veiculos = categoria.getVeiculos();
		List<VeiculoRepresentation> veiculoRepresentation = new ArrayList<>();
		for (Veiculo veiculo : veiculos) {
			veiculoRepresentation.add(new VeiculoRepresentation(veiculo));
		}

		return ResponseEntity.ok(veiculoRepresentation);
	}

}
