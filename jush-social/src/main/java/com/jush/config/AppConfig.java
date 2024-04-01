package com.jush.config;

import javax.security.sasl.AuthorizeCallback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

@Configuration
@EnableWebSecurity
public class AppConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
		.authorizeHttpRequests(Authorize -> Authorize
				.requestMatchers("/api/**").authenticated()
				.anyRequest().permitAll())
		.httpBasic().and()
		.csrf(csrf -> csrf.disable());
		
		
		return http.build();

	}
}
