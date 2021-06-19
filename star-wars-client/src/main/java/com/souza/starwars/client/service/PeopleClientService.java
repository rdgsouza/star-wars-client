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

import com.souza.starwars.client.domain.model.People;
import com.souza.starwars.client.domain.model.PeopleFilter;
import com.souza.starwars.client.exception.ClientApiException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class PeopleClientService {

	public RestTemplate restTemplate;
	public String url;

	public ResponseEntity<People> buscaPersonagemPorId() {

		try {
			URI resourceUri = URI.create(url);
			log.info("Fazendo a busca do personagem na API SWAP...");
			ResponseEntity<People> people = restTemplate.exchange(
					resourceUri, HttpMethod.GET, null, People.class);
			log.info("Busca concluida com sucesso!");

			return people;

		} catch (HttpClientErrorException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}

	public List<String> buscaPersonagemPorNome() {

		try {
			URI resourceUri = URI.create(url);

			log.info("Fazendo a busca dos personagens na API SWAP...");
			ResponseEntity<PeopleFilter> peopleFilter = restTemplate.exchange(
					resourceUri, HttpMethod.GET, geraHeaders(),
					PeopleFilter.class);
			log.info("Busca concluida com sucesso!");

			List<PeopleFilter> peoples = Arrays.asList(peopleFilter.getBody());

			StringBuilder stringBuilder = new StringBuilder();

			for (PeopleFilter p : peoples) {
				stringBuilder.append(p);
			}

			String result = stringBuilder.toString().replace("Name", "\n Name");

			return Arrays.asList(result);

		} catch (HttpClientErrorException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}

	public List<String> Listarpersonagens() {
		try {
			URI resourceUri = URI.create(url);
			log.info("Fazendo a busca de todos os personagens na API SWAPI...");
			ResponseEntity<PeopleFilter> peopleFilter = restTemplate.exchange(
					resourceUri, HttpMethod.GET, null,
					PeopleFilter.class);
			log.info("Busca finalizada com sucesso!");

			List<PeopleFilter> peoples = Arrays.asList(peopleFilter.getBody());

			StringBuilder stringBuilder = new StringBuilder();

			for (PeopleFilter p : peoples) {
				stringBuilder.append(p);
			}

			String result = stringBuilder.toString().replace("Name", "\n Name");

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
