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

		Mono<ResponseEntity<String>> result = WebClient.create().get().uri("http://google.com").retrieve()
				// .onStatus(status -> status.value() == 301,
				// clientResponse -> Mono.empty())
				.toEntity(String.class);// .block();
		// .bodyToMono(String.class)

		result.subscribe(s -> {
			System.out.println(s.getStatusCode().value());
			System.out.println(s.getBody());
		});

		// System.out.println("status code: " + result.getStatusCodeValue());
		// System.out.println("response body: " + result.getBody());
	}

}
