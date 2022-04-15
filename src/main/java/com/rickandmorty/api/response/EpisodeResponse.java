package com.rickandmorty.api.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EpisodeResponse {

	private String id;
	private String name;
	private String air_date;
	private String episode;
	private List<String> characters;
	private String url;
	
}
