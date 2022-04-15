package com.rickandmorty.api.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LocationResponse {
	
	private String id;
	private String name;
	private String type;
	private List<String> residents;
	private String url;

}
