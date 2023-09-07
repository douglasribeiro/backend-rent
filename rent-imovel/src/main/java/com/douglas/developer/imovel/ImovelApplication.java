package com.douglas.developer.imovel;

import org.dom4j.CDATA;
import org.hibernate.dialect.identity.JDataStoreIdentityColumnSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.tags.EditorAwareTag;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.douglas.developer.core.entity"})
@EnableJpaRepositories({"com.douglas.developer.core.repository"})
@ComponentScan("com.douglas.developer")
public class ImovelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImovelApplication.class, args);
    }
    
}
