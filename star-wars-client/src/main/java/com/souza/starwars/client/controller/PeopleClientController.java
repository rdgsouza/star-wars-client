package com.souza.starwars.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.souza.starwars.client.assembler.PeopleModelAssembler;
import com.souza.starwars.client.domain.model.People;
import com.souza.starwars.client.representationmodel.PeopleRepresentationModel;
import com.souza.starwars.client.service.PeopleClientService;

public class PeopleClientController {

	static PeopleModelAssembler peopleModelAssembler = new PeopleModelAssembler();

	public static List<String> listaPersonagens() {

			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://swapi.dev/api/people/";

			PeopleClientService peopleClientService = new PeopleClientService(restTemplate, uri);

			List<String> peoples = peopleClientService.Listarpersonagens();

			System.out.println("\n*** Informações dos personages em paginação ***");

			peoples.stream().forEach(p -> System.out.println(p));
			
			return peoples;

	}

	public static List<String> buscarPersonagemPorId(String idPersonagem) {

		RestTemplate restTemplate = new RestTemplate();

		PeopleClientService peopleClientService = new PeopleClientService(restTemplate,
				"https://swapi.dev/api/people/".concat(idPersonagem) + "/");

		ResponseEntity<People> p = peopleClientService.buscaPersonagemPorId();

		People people = p.getBody();

		PeopleRepresentationModel peopleRepresentationModel = peopleModelAssembler.toModel(people);

		System.out.println("\n*** Informação do personagem ***\n" + peopleRepresentationModel.toString());

		List<String> personagens = new ArrayList<>();
		personagens.add(peopleRepresentationModel.toString());
		
		return personagens;
	}

	public static List<String> buscarPersonagemPoNome(String nome) {

		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://swapi.dev/api/people/";

		UriComponents uriComParametros = UriComponentsBuilder.fromHttpUrl(uri).queryParam(
				"search", nome.toString()).encode().build();

		PeopleClientService peopleClientService = new PeopleClientService(restTemplate, uriComParametros.toString());

		List<String> peoples = peopleClientService.buscaPersonagemPorNome();

		System.out.println("\n*** Informação do personagens em paginação ***");

		peoples.stream().forEach(p -> System.out.println(p));
		
		return peoples;

	}

}
