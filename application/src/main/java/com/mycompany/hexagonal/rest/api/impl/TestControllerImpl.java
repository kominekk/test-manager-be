package com.mycompany.hexagonal.rest.api.impl;

import com.mycompany.hexagonal.model.Test;
import com.mycompany.hexagonal.rest.api.TestController;
import com.mycompany.hexagonal.rest.api.model.TestModelMapper;
import com.mycompany.hexagonal.rest.api.model.request.TestChangeStatusRequest;
import com.mycompany.hexagonal.rest.api.model.request.TestCreateRequest;
import com.mycompany.hexagonal.rest.api.model.response.TestResponse;
import com.mycompany.hexagonal.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tests")
@CrossOrigin(origins = "http://localhost:3000")
public class TestControllerImpl implements TestController {

    private TestService testService;
    private TestModelMapper mapper;

    @Autowired
    public TestControllerImpl(TestService testService, TestModelMapper mapper) {
        this.testService = testService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<TestResponse>> getTests() {
        return new ResponseEntity<>(mapper.map(testService.getTests()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TestResponse> addTest(@RequestBody @Validated TestCreateRequest testCreateRequest, BindingResult result) {
        if (!result.hasErrors()) {
            TestResponse testResponse = mapper.map(testService.addTest(mapper.map(testCreateRequest)));
            return ResponseEntity.ok(testResponse);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<TestResponse> changeExecutionStatus(@RequestBody @Validated TestChangeStatusRequest request, BindingResult result) {
        if (!result.hasErrors()) {
            Test test = testService.changeTestExecutionStatus(request.getId(), mapper.mapStatus(request.getNewStatus()));
            TestResponse testResponse = mapper.map(test);
            return ResponseEntity.ok(testResponse);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
