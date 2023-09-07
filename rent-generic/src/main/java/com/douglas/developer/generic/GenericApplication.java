package com.douglas.developer.generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.douglas.developer.core.entity"})
@EnableJpaRepositories({"com.douglas.developer.core.repository"})
@ComponentScan("com.douglas.developer")
public class GenericApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenericApplication.class, args);
    }
}
