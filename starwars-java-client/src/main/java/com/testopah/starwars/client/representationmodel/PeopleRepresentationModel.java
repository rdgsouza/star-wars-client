package com.testopah.starwars.client.representationmodel;

import java.util.List;

import lombok.Data;

@Data
public class PeopleRepresentationModel {

	private String name;
	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String eye_color;
	private String birth_year;
	private String gender;
	private String homeworld;

	private List<String> films;
	private List<String> species;
	private List<String> vehicles;
	private List<String> starships;
	
	private String created;
	private String edited;
	private String url;
	
	@Override
	public String toString() {
		return String.format("\n"
		   + " Name: %s \n Height: %s \n Mass: %s \n Hair color: %s \n Skin color: %s \n Eye color: %s "
		   + "\n Birth year: %s \n Gender: %s \n Homeworld: %s \n Films: %s \n Species: %s \n Vehicles :%s "
		   + "\n Starships: %s \n Created: %s \n Edited: %s \n Url: %s"
		   ,name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld 
		   ,films, species, vehicles, starships, created, edited, url);
	}
}
