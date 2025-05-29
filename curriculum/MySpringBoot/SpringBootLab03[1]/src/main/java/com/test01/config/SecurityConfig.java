package com.test01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//debug
		System.out.println("===filterChain running===");
		//authenticated rules / login auth / logout auth
		http.csrf(csrf -> csrf.disable()) // 세션 기반이 아닌 토큰 기반으로 진행을 하기 때문에 비활성화
			.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/register", "/css/**", "/js/**").permitAll()
					.anyRequest().authenticated()) //나머지 요청은 반드시 인증 되어야 함
			
			.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/home", true).permitAll()) //no auth necessary
			
			.logout(logout -> logout.logoutSuccessUrl("/").permitAll()); //로그아웃 자체는 모든 사용자에게 허용
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //password hashcode -> encrypt password
	}
}
