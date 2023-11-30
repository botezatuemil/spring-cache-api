package com.example.simplecacheapi.service;

import com.example.simplecacheapi.model.Categories;
import com.example.simplecacheapi.model.JsonSpec;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpMethod.GET;

@Service
public class JsonSpecService {
    protected RestTemplate restTemplate;

    @Value("${books.basePathV1}")
    private String basePath;

    @Autowired
    public JsonSpecService (RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Cacheable("spec")
    public JsonSpec fetchJsonSpec(final Categories categories) {

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw  new IllegalStateException(e);
        }
        HttpHeaders httpHeaders = new HttpHeaders();

        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("categories", categories);
        String path = UriComponentsBuilder.fromPath("/{categories}").buildAndExpand(uriVariables).toUriString();
        String uri = UriComponentsBuilder.fromHttpUrl(basePath).path(path).build().toUriString();

        HttpEntity<JSONPObject> entity = new HttpEntity<>(httpHeaders);

        return this.restTemplate.exchange(uri, GET, entity, JsonSpec.class).getBody();
    }
}
