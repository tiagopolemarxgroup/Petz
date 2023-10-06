package com.tiago.petz.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseDTO {

	private HttpStatus httpStatus;
	private String description;
	private List<ErrorDTO> erros = new ArrayList<>();

	public ResponseDTO(HttpStatus httpStatus, String description, List<ErrorDTO> erros) {
		this.httpStatus = httpStatus;
		this.description = description;
		this.erros = erros;
	}

	public ResponseDTO(HttpStatus httpStatus, String description) {
		super();
		this.httpStatus = httpStatus;
		this.description = description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ErrorDTO> getErros() {
		return erros;
	}

	public void setErros(List<ErrorDTO> erros) {
		this.erros = erros;
	}

}
