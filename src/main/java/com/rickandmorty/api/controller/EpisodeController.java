package com.rickandmorty.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rickandmorty.api.client.EpisodeClient;
import com.rickandmorty.api.response.EpisodeResponse;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("webclient")
public class EpisodeController {

	@Autowired
	EpisodeClient client;
	
	@GetMapping("/episodes/{id}")
	public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
		return client.findEpisodeById(id);
	}
	
}
