package com.mycompany.hexagonal.service.config;

import com.mycompany.hexagonal.service.adapter.TestServiceAdapter;
import com.mycompany.hexagonal.service.api.TestService;
import com.mycompany.hexagonal.spi.TestPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TestService getTestService(TestPersistencePort testPersistencePort) {
        return new TestServiceAdapter(testPersistencePort);
    }
}
