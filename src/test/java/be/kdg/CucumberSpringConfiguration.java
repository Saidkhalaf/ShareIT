package be.kdg;


import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

import org.springframework.context.annotation.Configuration;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberSpringConfiguration {
}


@Configuration
class TestConfig {
}
