package com.example.simplecacheapi.api;

import com.example.simplecacheapi.model.Categories;
import com.example.simplecacheapi.model.JsonSpec;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.simplecacheapi.constants.ApiConstants.JSON_SPEC_MANAGEMENT;
import static com.example.simplecacheapi.constants.ApiConstants.V1;

@RequestMapping(V1)
@Api(value = V1, tags = {JSON_SPEC_MANAGEMENT})
public interface JsonSpecResourceAPI {

    @GetMapping(value = "/{category}")
    @ApiResponses(value = {@ApiResponse(code  =200, message = "ok", response = JsonSpec.class)})
    public JsonSpec getJsonSpec(@ApiParam(value = "desc", required = true) @PathVariable(name = "category", required = true) final Categories categories);
}
