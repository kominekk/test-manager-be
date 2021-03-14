package com.mycompany.hexagonal.spi;


import com.mycompany.hexagonal.model.ExecutionStatus;
import com.mycompany.hexagonal.model.Test;

import java.util.List;

public interface TestPersistencePort {
    Test addTest(Test test);

    List<Test> getTests();

    Test changeExecutionStatus(Integer id, ExecutionStatus newStatus);

}
