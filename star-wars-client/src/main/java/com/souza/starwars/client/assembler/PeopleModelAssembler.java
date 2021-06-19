package com.souza.starwars.client.assembler;

import org.modelmapper.ModelMapper;

import com.souza.starwars.client.domain.model.People;
import com.souza.starwars.client.representationmodel.PeopleRepresentationModel;

public class PeopleModelAssembler {

	ModelMapper modelMapper = new ModelMapper();

	public PeopleRepresentationModel toModel(People people) {

		return modelMapper.map(people, PeopleRepresentationModel.class);
	}

}