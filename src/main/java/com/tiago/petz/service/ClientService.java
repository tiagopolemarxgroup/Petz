package com.tiago.petz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.petz.exception.ClientNotFoundException;
import com.tiago.petz.model.Client;
import com.tiago.petz.repository.ClienteRepository;

@Service
public class ClientService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Client save(Client client) {
		return clienteRepository.save(client);
	}

	public List<Client> findAll() {
		return clienteRepository.findAll();
	}

	public List<Client> findByName(String name) {
		return clienteRepository.findByNameContainingIgnoreCase(name);
	}

	public List<Client> findByEMail(String email) {
		return clienteRepository.findByEmailContainingIgnoreCase(email);
	}

	public Client findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found: " + id));
	}

	public Client update(Long id, Client client) {
		Client clientDB = this.findById(id);
		clientDB.setName(client.getName());
		clientDB.setEmail(client.getEmail());
		return clienteRepository.save(clientDB);
	}

	public void delete(Long id) {
		this.findById(id);
		clienteRepository.deleteById(id);
	}

}
