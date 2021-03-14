package com.mycompany.hexagonal.rest.api.model;


import com.mycompany.hexagonal.model.ExecutionStatus;
import com.mycompany.hexagonal.model.Test;
import com.mycompany.hexagonal.rest.api.model.request.TestCreateRequest;
import com.mycompany.hexagonal.rest.api.model.response.TestResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestModelMapper {

    public Test map(TestCreateRequest testCreateRequest) {
        return Test.builder()
                .name(testCreateRequest.getName())
                .description(testCreateRequest.getDescription())
                .executionStatus(ExecutionStatus.UNDEFINED)
                .build();
    }

    public TestResponse map(Test test) {
        return TestResponse.builder()
                .id(test.getId())
                .name(test.getName())
                .description(test.getDescription())
                .executionStatus(test.getExecutionStatus().name())
                .build();
    }

    public List<TestResponse> map(List<Test> tests) {
        return tests.stream().map(test -> map(test)).collect(Collectors.toList());
    }

    public ExecutionStatus mapStatus(String status) {
        return ExecutionStatus.valueOf(status);
    }
}