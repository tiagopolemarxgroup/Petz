package com.tiago.petz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.petz.model.Client;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {

	
	List<Client> findByNameContainingIgnoreCase(String name);
	List<Client> findByEmailContainingIgnoreCase(String email);
}
