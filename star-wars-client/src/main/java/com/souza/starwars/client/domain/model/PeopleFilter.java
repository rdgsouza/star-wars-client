package com.souza.starwars.client.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.souza.starwars.client.representationmodel.PeopleRepresentationModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleFilter {

	private Integer count;
	private String next;
    private String previous;
    
	private List<PeopleRepresentationModel> results;
	private List<PeopleFilter> peoples;
	
	@Override
	public String toString() {
		return String.format("\n Count: %d \n Next: %s \n Previous: %s \n Results: %s"
			,count, next, previous, results);
	}

}
