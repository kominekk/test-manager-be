package com.mycompany.hexagonal.jpa.adapter;

import com.mycompany.hexagonal.jpa.adapter.mapper.TestAdapterMapper;
import com.mycompany.hexagonal.jpa.entity.TestEntity;
import com.mycompany.hexagonal.jpa.repository.TestRepository;
import com.mycompany.hexagonal.model.ExecutionStatus;
import com.mycompany.hexagonal.model.Test;
import com.mycompany.hexagonal.spi.TestPersistencePort;

import java.util.List;
import java.util.Optional;

public class TestJpaAdapter implements TestPersistencePort {

    private TestRepository testRepository;
    private TestAdapterMapper mapper;

    public TestJpaAdapter(TestRepository testRepository, TestAdapterMapper mapper) {
        this.testRepository = testRepository;
        this.mapper = mapper;
    }

    @Override
    public Test addTest(Test test) {
        TestEntity result = testRepository.save(mapper.toTestEntity(test));
        return mapper.toTest(result);
    }

    @Override
    public List<Test> getTests() {
        return mapper.toTests(testRepository.findAll());
    }

    @Override
    public Test changeExecutionStatus(Integer id, ExecutionStatus newStatus) {
        Optional<TestEntity> result = testRepository.findById(id);
        if (result.isPresent()) {
            TestEntity toUpdate = result.get();
            toUpdate.setExecutionStatus(newStatus);
            return mapper.toTest(testRepository.save(toUpdate));
        }
        return null;
    }

}
