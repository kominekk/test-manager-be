package com.mycompany.hexagonal.service.api;


import com.mycompany.hexagonal.model.ExecutionStatus;
import com.mycompany.hexagonal.model.Test;

import java.util.List;

public interface TestService {
    Test addTest(Test test);

    List<Test> getTests();

    Test changeTestExecutionStatus(Integer testId, ExecutionStatus executionStatus);
}
