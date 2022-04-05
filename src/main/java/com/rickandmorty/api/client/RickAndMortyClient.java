package com.rickandmorty.api.client;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.rickandmorty.api.response.CharacterResponse;

import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class RickAndMortyClient {

	private final WebClient webClient;

	public RickAndMortyClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}

	public Mono<CharacterResponse> findCharacterById(String id) {
		org.slf4j.Logger log = LoggerFactory.getLogger(RickAndMortyClient.class);
		log.info("Buscando personagem de id [{}]", id);
		return webClient.get().uri("/character/" + id).accept(APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique informações inseridas")))
				.bodyToMono(CharacterResponse.class);
	}

}
