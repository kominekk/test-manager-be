package com.mycompany.hexagonal.rest.api;

import com.mycompany.hexagonal.rest.api.model.request.TestCreateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@Api(tags = "Custom API")
public interface TestController {

    @ApiOperation(value = "Get tests")
    ResponseEntity getTests();

    @ApiOperation(value = "Add new test")
    ResponseEntity addTest(TestCreateRequest testCreateRequest, BindingResult result);

}

