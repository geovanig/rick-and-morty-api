package com.rickandmorty.api.client;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.rickandmorty.api.response.CharacterResponse;
import com.rickandmorty.api.response.EpisodeResponse;
import com.rickandmorty.api.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EpisodeClient {

	private final WebClient webClient;

	public EpisodeClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}
	
	public Mono<EpisodeResponse> findEpisodeById(String id) {
		org.slf4j.Logger log = LoggerFactory.getLogger(EpisodeClient.class);
		log.info("Buscando episódio de id [{}]", id);
		return webClient.get().uri("/episode/" + id).accept(APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique informações inseridas")))
				.bodyToMono(EpisodeResponse.class);
	}

}
