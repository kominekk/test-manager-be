package com.mycompany.hexagonal.jpa.repository;


import com.mycompany.hexagonal.jpa.entity.TestEntity;
import com.mycompany.hexagonal.model.ExecutionStatus;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestEntity, Integer> {


}
