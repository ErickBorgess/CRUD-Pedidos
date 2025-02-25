package com.estudo.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) //Desabilita o CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll() //Libera acesso ao h2
                .requestMatchers("/**").permitAll() //Libera a api (opção)
                .anyRequest().authenticated() //Restringe outras rotas
            )
            .headers(headers -> headers.frameOptions().disable()) //permite o h2 rodar corretamente
            .formLogin(login -> login.disable()) //Desabilita a tela de login padrão
            .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}
