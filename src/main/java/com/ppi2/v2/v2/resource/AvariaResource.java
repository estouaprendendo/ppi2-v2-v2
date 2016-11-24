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
import com.ppi2.v2.v2.representation.AvariaRepresentation;
import com.ppi2.v2.v2.service.AvariaService;

@CrossOrigin
@RestController
@RequestMapping("/avarias")
public class AvariaResource {
	@Autowired
	private AvariaService avariaService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<AvariaRepresentation>> listAll() {

		List<Avaria> avarias = avariaService.findAll();
		List<AvariaRepresentation> representation = new ArrayList<>();
		for (Avaria p : avarias) {
			representation.add(new AvariaRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<AvariaRepresentation> findById(@PathVariable("id") Long id) {

		Avaria avaria = avariaService.findById(id);
		AvariaRepresentation representation = new AvariaRepresentation(avaria);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody AvariaRepresentation representation) {

		Avaria avaria = avariaService.save(AvariaRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaria.getIdAvaria())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody AvariaRepresentation representation,
			@PathVariable("id") Long id) {

		representation.setIdentifier(id);
		avariaService.update(AvariaRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<AvariaRepresentation> delete(@PathVariable("id") Long id) {

		Avaria avaria = avariaService.findById(id);
		AvariaRepresentation representation = new AvariaRepresentation(avaria);
		avariaService.delete(avaria);
		return ResponseEntity.ok(representation);
	}
}
