package com.tiago.petz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.petz.model.Client;
import com.tiago.petz.request.ClientRequest;
import com.tiago.petz.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public ResponseEntity<Client> save(@Valid @RequestBody ClientRequest clientRequest){
		return new ResponseEntity<>(clientService.save(clientRequest.convertToClient()), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok(clientService.findAll());
	}
	
	@GetMapping("/name")
	public ResponseEntity<List<Client>> findByName(@RequestParam String name){
		return ResponseEntity.ok(clientService.findByName(name));
	}
	
	@GetMapping("/email")
	public ResponseEntity<List<Client>> findByEmail(@RequestParam String email){
		return ResponseEntity.ok(clientService.findByEMail(email));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		return ResponseEntity.ok(clientService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id,@Valid @RequestBody ClientRequest clientRequest){
		return new ResponseEntity<>(clientService.update(id, clientRequest.convertToClient()), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

	
}
