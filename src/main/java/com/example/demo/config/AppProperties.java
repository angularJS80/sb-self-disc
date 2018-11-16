package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("my-app")
@Getter @Setter
public class AppProperties {

    private String clientId;

    private String clientSecret;

}
