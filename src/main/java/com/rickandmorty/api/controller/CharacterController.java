package com.rickandmorty.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rickandmorty.api.client.CharacterClient;
import com.rickandmorty.api.response.CharacterResponse;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("webclient")
public class CharacterController {

	@Autowired
	CharacterClient client;
	
	@GetMapping("/characters/{id}")
	public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
		return client.findCharacterById(id);
	}
	
}
