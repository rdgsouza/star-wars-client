package com.souza.starwars.client.exception;

import org.springframework.web.client.HttpClientErrorException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientApiException(String message, HttpClientErrorException e) {
		super(message, e);
		
		log.warn(message);
	}
	
 }