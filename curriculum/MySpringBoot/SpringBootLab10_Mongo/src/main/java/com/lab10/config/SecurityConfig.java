package com.lab10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 🔐 Allow POST/PUT/DELETE without CSRF token
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll() // 🔓 Allow all URLs without login
                .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults()); // Optional: allows basic auth (useful later)

        return http.build();
    }
}