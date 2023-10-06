package com.tiago.petz.request;

import javax.validation.constraints.NotBlank;

import com.tiago.petz.model.Client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
	
	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	private String email;
	
	public Client convertToClient() {
		return new Client(null, name, email);
	}
	
}
