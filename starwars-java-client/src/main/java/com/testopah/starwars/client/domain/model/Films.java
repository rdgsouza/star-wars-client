package com.testopah.starwars.client.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Films {

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
   
}
