package com.mycompany.hexagonal.service.adapter;

import com.mycompany.hexagonal.model.ExecutionStatus;
import com.mycompany.hexagonal.model.Test;
import com.mycompany.hexagonal.service.api.TestService;
import com.mycompany.hexagonal.spi.TestPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestServiceAdapter implements TestService {

    private TestPersistencePort testPersistencePort;

    @Autowired
    public TestServiceAdapter(TestPersistencePort testPersistencePort) {
        this.testPersistencePort = testPersistencePort;
    }

    @Override
    public Test addTest(Test test) {
        return testPersistencePort.addTest(test);

    }

    @Override
    public List<Test> getTests() {
        return testPersistencePort.getTests();
    }

    @Override
    public Test changeTestExecutionStatus(Integer testId, ExecutionStatus newStatus) {
        return testPersistencePort.changeExecutionStatus(testId, newStatus);

    }
}
