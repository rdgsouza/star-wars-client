package com.testopah.starwars.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.testopah.starwars.client.assembler.PeopleModelAssembler;
import com.testopah.starwars.client.domain.model.People;
import com.testopah.starwars.client.exception.ClientApiException;
import com.testopah.starwars.client.representationmodel.PeopleRepresentationModel;
import com.testopah.starwars.client.service.PeopleClientService;

public class PeopleClientController {

	static PeopleModelAssembler peopleModelAssembler = new PeopleModelAssembler();

	public static void listaPersonagens() {

		try {

			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://swapi.dev/api/people/";

			PeopleClientService peopleClientService = new PeopleClientService(restTemplate, uri);

			List<String> peoples = peopleClientService.Listarpersonagens();

			System.out.println("\n*** Informações dos personages em paginação ***");

			peoples.stream().forEach(p -> System.out.println(p));

    		} catch (ClientApiException e) {
		}
	}

	public static void buscarPersonagemPorId(String idPersonagem) {

		RestTemplate restTemplate = new RestTemplate();

		PeopleClientService peopleClientService = new PeopleClientService(restTemplate,
				"https://swapi.dev/api/people/".concat(idPersonagem) + "/");

		ResponseEntity<People> p = peopleClientService.buscaPersonagemPorId();

		People people = p.getBody();

		PeopleRepresentationModel peopleRepresentationModel = peopleModelAssembler.toModel(people);

		System.out.println("\n*** Informação do personagem ***\n" + peopleRepresentationModel.toString());

	}

	public static void buscarPersonagemPoNome(String nome) {

		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://swapi.dev/api/people/";

		UriComponents uriComParametros = UriComponentsBuilder.fromHttpUrl(uri).queryParam("search", nome).build();

		PeopleClientService peopleClientService = new PeopleClientService(restTemplate, uriComParametros.toString());

		List<String> peoples = peopleClientService.buscaPersonagemPorNome();

		System.out.println("\n*** Informação do personagens em paginação ***");

		peoples.stream().forEach(p -> System.out.println(p));

	}

}
