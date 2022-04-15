package com.rickandmorty.api.client;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.rickandmorty.api.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class LocationClient {

	private final WebClient webClient;

	public LocationClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}

	public Mono<LocationResponse> findLocationById(String id) {
		org.slf4j.Logger log = LoggerFactory.getLogger(LocationClient.class);
		log.info("Buscando local de id [{}]", id);
		return webClient.get().uri("/location/" + id).accept(APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique informações inseridas")))
				.bodyToMono(LocationResponse.class);
	}

}
