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

import com.ppi2.v2.v2.domain.Cliente;
import com.ppi2.v2.v2.representation.ClienteRepresentation;
import com.ppi2.v2.v2.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<ClienteRepresentation>> listAll() {

		List<Cliente> clientes = clienteService.findAll();
		List<ClienteRepresentation> representation = new ArrayList<>();
		for (Cliente p : clientes) {
			representation.add(new ClienteRepresentation(p));
		}

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ClienteRepresentation> findById(@PathVariable("id") Long id) {

		Cliente cliente = clienteService.findById(id);
		ClienteRepresentation representation = new ClienteRepresentation(cliente);

		return ResponseEntity.ok(representation);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody ClienteRepresentation representation) {

		Cliente cliente = clienteService.save(ClienteRepresentation.build(representation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody ClienteRepresentation representation,
			@PathVariable("id") Long id) {

		representation.setIdentifier(id);
		clienteService.update(ClienteRepresentation.build(representation));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<ClienteRepresentation> delete(@PathVariable("id") Long id) {

		Cliente cliente = clienteService.findById(id);
		ClienteRepresentation representation = new ClienteRepresentation(cliente);
		clienteService.delete(cliente);
		return ResponseEntity.ok(representation);
	}

	@RequestMapping(value = "/cpf/{nCpf}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ClienteRepresentation> findByCpf(@PathVariable("nCpf") String nCpf) {

		Cliente cliente = clienteService.findByCpf(nCpf);

		ClienteRepresentation representation = new ClienteRepresentation(cliente);

		return ResponseEntity.ok(representation);
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody HttpEntity<ClienteRepresentation> findById(@PathVariable("id") Long id) {
//
//		Cliente cliente = clienteService.findById(id);
//		ClienteRepresentation representation = new ClienteRepresentation(cliente);
//
//		return ResponseEntity.ok(representation);
//	}

}
