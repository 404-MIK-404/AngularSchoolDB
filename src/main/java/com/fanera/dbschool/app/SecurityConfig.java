package com.fanera.dbschool.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:enviroment.school.yaml")
@ConfigurationProperties(prefix = "security")
public class SecurityConfig {

    private String secret;

}
