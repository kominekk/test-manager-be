package com.mycompany.hexagonal.jpa.adapter.mapper;

import com.mycompany.hexagonal.jpa.entity.TestEntity;
import com.mycompany.hexagonal.model.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TestAdapterMapper {

    public TestEntity toTestEntity(Test test) {
        TestEntity testEntity = new TestEntity();
        BeanUtils.copyProperties(test, testEntity);
        return testEntity;
    }

    public Test toTest(TestEntity testEntity) {
        Test test = new Test();
        BeanUtils.copyProperties(testEntity, test);
        return test;

    }

    public List<Test> toTests(Iterable<TestEntity> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(entity -> toTest(entity)).collect(Collectors.toList());

    }

}
