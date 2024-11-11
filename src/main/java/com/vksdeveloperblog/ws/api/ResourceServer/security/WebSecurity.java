package com.vksdeveloperblog.ws.api.ResourceServer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // Configure HTTP Security
        http.authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
            .oauth2ResourceServer(outh2 -> outh2.jwt(jwt -> {}));

        return http.build();
    }
}