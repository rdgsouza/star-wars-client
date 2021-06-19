package com.souza.starwars.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.souza.starwars.client.assembler.FilmsModelAssembler;
import com.souza.starwars.client.domain.model.Films;
import com.souza.starwars.client.representationmodel.FilmsRepresentationModel;
import com.souza.starwars.client.service.FilmsClientService;

public class FilmsClientController {

	static FilmsModelAssembler filmsModelAssembler = new FilmsModelAssembler();

	public static List<String> listaFilmes() {

			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://swapi.dev/api/films/";

			FilmsClientService filmsClientService = new FilmsClientService(restTemplate, uri);

			List<String> films = filmsClientService.ListarFilmes();

			System.out.println("\n*** Informações dos filmes em paginação ***");

			films.stream().forEach(f -> System.out.println(f));

			return films;			
	}

	public static List<String> buscarFilmPorId(String idFilme) {

		RestTemplate restTemplate = new RestTemplate();

		FilmsClientService filmsClientService = new FilmsClientService(restTemplate,
				"https://swapi.dev/api/films/".concat(idFilme) + "/");

		ResponseEntity<Films> f = filmsClientService.buscaFilmePorId();

		Films film = f.getBody();

		FilmsRepresentationModel filmRepresentationModel = filmsModelAssembler.toModel(film);

		System.out.println("\n*** Informação do filme ***\n" + filmRepresentationModel.toString());
		
		List<String> films = new ArrayList<>();
		films.add(filmRepresentationModel.toString());
		
		return films;
	}

	public static List<String> buscarfilmesPorNome(String nome) {

		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://swapi.dev/api/films/";

		UriComponents uriComParametros = UriComponentsBuilder.fromHttpUrl(uri).queryParam(
				"search", nome.toString()).encode().build();

		FilmsClientService filmsClientService = new FilmsClientService(restTemplate, uriComParametros.toString());

		List<String> films = filmsClientService.buscaFilmesPorNome();

		System.out.println("\n*** Informação dos filmes em paginação ***");

		films.stream().forEach(f -> System.out.println(f));
		
		return films;

	}

}
