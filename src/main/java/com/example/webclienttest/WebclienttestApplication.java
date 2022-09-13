package com.example.webclienttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebclienttestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclienttestApplication.class, args);

		ResponseEntity<String> result = WebClient.create().get().uri("http://google.com").retrieve()
				// .onStatus(status -> status.value() == 301,
				// clientResponse -> Mono.empty())
				.toEntity(String.class).block();

		System.out.println("status code: " + result.getStatusCodeValue());
		System.out.println("response body: " + result.getBody());
	}

}
