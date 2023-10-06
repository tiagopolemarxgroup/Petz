package com.tiago.petz.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.google.common.net.HttpHeaders;
import com.tiago.petz.dto.ErrorDTO;
import com.tiago.petz.dto.ResponseDTO;

@RestControllerAdvice
public class ExecptionHandlerAdvice {

	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<ResponseDTO> clientNotFound(ClientNotFoundException ex, HttpServletRequest request) {
		ResponseDTO response = new ResponseDTO(HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		List<ErrorDTO> errors = ex.getBindingResult().getFieldErrors()
				.stream().map(error -> new ErrorDTO(error.getDefaultMessage())).collect(Collectors.toList());
		
		ResponseDTO response = new ResponseDTO(HttpStatus.BAD_REQUEST, "Invalid fields", errors);
		return new ResponseEntity<Object>(response, status);
	}
}
