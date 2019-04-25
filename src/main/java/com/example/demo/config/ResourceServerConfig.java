package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("events");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .anonymous()
                .and()
                    .authorizeRequests()
                    //.antMatchers(HttpMethod.GET, "/**/**").permitAll()
                    .antMatchers("/product").authenticated()
                    //.antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
                .and()
                    .csrf()
                    .disable()
                    .exceptionHandling()
                    .accessDeniedHandler(new OAuth2AccessDeniedHandler())
        ;
    }
}
