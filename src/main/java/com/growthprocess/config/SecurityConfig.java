package com.growthprocess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())  // 關閉CSRF
			.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())  // 所有請求都放行
			.formLogin(login -> login.disable())
			.httpBasic(basic -> basic.disable());  // 可移除，不使用 Basic 認證
		
		return http.build();
	}
}
