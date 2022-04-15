package com.rickandmorty.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rickandmorty.api.client.LocationClient;
import com.rickandmorty.api.response.LocationResponse;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("webclient")
public class LocationController {

	@Autowired
	LocationClient client;
	
	@GetMapping("/locations/{id}")
	public Mono<LocationResponse> getLocationById(@PathVariable String id){
		return client.findLocationById(id);
	}
	
}
