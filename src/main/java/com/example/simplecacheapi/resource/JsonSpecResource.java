package com.example.simplecacheapi.resource;

import com.example.simplecacheapi.api.JsonSpecResourceAPI;
import com.example.simplecacheapi.model.Categories;
import com.example.simplecacheapi.model.JsonSpec;
import com.example.simplecacheapi.service.JsonSpecService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonSpecResource implements JsonSpecResourceAPI {
    private JsonSpecService jsonSpecService;

    public JsonSpecResource(JsonSpecService jsonSpecService) {this.jsonSpecService = jsonSpecService; }

    @Override
    public JsonSpec getJsonSpec(Categories categories) {
        return jsonSpecService.fetchJsonSpec(categories);
    }
}
