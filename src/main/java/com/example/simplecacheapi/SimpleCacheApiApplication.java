package com.example.simplecacheapi;

import com.example.simplecacheapi.exception.RestTemplateClientErrorHandler;
import com.example.simplecacheapi.service.JsonSpecService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@EnableAsync
@SpringBootApplication
public class SimpleCacheApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCacheApiApplication.class, args);
	}

	@Bean
	@Primary
	RestTemplate getRestTemplate() {
		final var restTemplate = new RestTemplate();
		final var requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(requestFactory);
		restTemplate.setErrorHandler(new RestTemplateClientErrorHandler());
		return restTemplate;
	}
	@Bean
	JsonSpecService getJsonSpecService() {
		return new JsonSpecService(getRestTemplate());
	}
}
