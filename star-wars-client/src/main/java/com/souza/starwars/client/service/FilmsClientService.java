package com.souza.starwars.client.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.souza.starwars.client.domain.model.Films;
import com.souza.starwars.client.domain.model.FilmsFilter;
import com.souza.starwars.client.exception.ClientApiException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class FilmsClientService {

	public RestTemplate restTemplate;
	public String url;

	public ResponseEntity<Films> buscaFilmePorId() {

		try {
			URI resourceUri = URI.create(url);
			log.info("Fazendo a busca do filme na API SWAP...");
			ResponseEntity<Films> films = restTemplate.exchange(
					resourceUri, HttpMethod.GET, null, Films.class);
			log.info("Busca concluida com sucesso!");

			return films;

		} catch (HttpClientErrorException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}

	public List<String> buscaFilmesPorNome() {

		try {
			URI resourceUri = URI.create(url);

			log.info("Fazendo a busca dos filmes na API SWAP...");
			ResponseEntity<FilmsFilter> filmsFilter = restTemplate.exchange(
					resourceUri, HttpMethod.GET, geraHeaders(), FilmsFilter.class);
			log.info("Busca concluida com sucesso!");

			List<FilmsFilter> films = Arrays.asList(filmsFilter.getBody());

			StringBuilder stringBuilder = new StringBuilder();

			for (FilmsFilter f : films) {
				stringBuilder.append(f);
			}

			String result = stringBuilder.toString().replace("Title", "\n Title");

			return Arrays.asList(result);

		} catch (HttpClientErrorException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}

	public List<String> ListarFilmes() {
		try {
			URI resourceUri = URI.create(url);
			log.info("Fazendo a busca de todos os filmes na API SWAPI...");
			ResponseEntity<FilmsFilter> fimsFilter = restTemplate.exchange(
					resourceUri, HttpMethod.GET, null,
					FilmsFilter.class);
			log.info("Busca finalizada com sucesso!");

			List<FilmsFilter> films = Arrays.asList(fimsFilter.getBody());

			StringBuilder stringBuilder = new StringBuilder();

			for (FilmsFilter f : films) {
				stringBuilder.append(f);
			}

			String result = stringBuilder.toString().replace("Title", "\n Title");

			return Arrays.asList(result);

		} catch (HttpClientErrorException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}

	public HttpEntity<String> geraHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
				+ "Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		return entity;
	}

}
