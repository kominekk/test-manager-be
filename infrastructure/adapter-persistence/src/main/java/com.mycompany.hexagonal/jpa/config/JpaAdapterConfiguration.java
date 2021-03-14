package com.mycompany.hexagonal.jpa.config;

import com.mycompany.hexagonal.jpa.adapter.TestJpaAdapter;
import com.mycompany.hexagonal.jpa.adapter.mapper.TestAdapterMapper;
import com.mycompany.hexagonal.jpa.repository.TestRepository;
import com.mycompany.hexagonal.spi.TestPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaAdapterConfiguration {

    @Bean
    public TestPersistencePort getTestPersistencePort(TestRepository testRepository, TestAdapterMapper mapper) {
        return new TestJpaAdapter(testRepository, mapper);
    }
}