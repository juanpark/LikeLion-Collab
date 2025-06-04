package com.test03.config;

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
    //authenticated 규칙 / 로그인 권한 / 로그아웃 권한
    http.csrf((csrfConfig) -> csrfConfig.disable()) //세션 기반이 아닌 토큰 기반으로 진행하기 때문에 비활성화
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/register", "/css/**", "/js/**","/index","/login","/h2-console").permitAll() // 인증없이 허용
            .anyRequest().authenticated() // 나머지 요청은 반드시 인증되어야 함
        )
        .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/home",true));
//        .logout(logout -> logout
//            .logoutSuccessUrl("/index")
//            .permitAll() // 로그아웃 자체는 모든 사용자에게 허용
//        );
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // 패스워드 전용 해쉬 코드 -> 비밀번호 암호화
  }
}
