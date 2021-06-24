package com.souza.starwars.client.exception;

import org.springframework.web.client.RestClientResponseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientApiException(String message, RestClientResponseException cause) {
		super(message, cause);
		
		log.warn(message);
//		log.warn(cause.getResponseBodyAsString());
	}
	
 }