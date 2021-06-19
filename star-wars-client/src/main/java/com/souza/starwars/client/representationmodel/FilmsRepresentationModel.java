package com.souza.starwars.client.representationmodel;

import java.util.List;

import lombok.Data;

@Data
public class FilmsRepresentationModel {

	   private String title;
	   private int episode_id;
	   private String opening_crawl;
	   private String director;
	   private String producer;
	   private String release_date;
	   private String created; 
	   private String edited;
	   private String url;

	   private List<String> characters;
	   private List<String> planets;
	   private List<String> starships;
	   private List<String> vehicles;
	   private List<String> species;

		@Override
		public String toString() {
			return String.format("\n"
			  + " Title: %s \n Episode id: %d \n Opening crawl: %s \n Director: %s \n Producer: "
			  + "%s \n Release Date: %s \n Created: %s \n Edited: %s \n Url: %s \n Characters: %s "
			  + "\n Planets: %s \n Starships :%s \n Vehicles :%s \n Species: %s"
			  ,title, episode_id, opening_crawl, director, producer, release_date, created, edited, url 
			  ,characters, planets, starships, vehicles, species);
		}
	   
}
