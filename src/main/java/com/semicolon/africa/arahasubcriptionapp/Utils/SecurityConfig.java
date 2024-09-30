//package com.semicolon.africa.arahasubcriptionapp.Utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtRequestFilter jwtRequestFilter;
//
//    public SecurityConfig(JwtRequestFilter jwtRequestFilter){
//        this.jwtRequestFilter = jwtRequestFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http){
//        try {
//            http.csrf( csrf -> csrf.ignoringRequestMatchers("http://localhost:8080/register"))
//                    .authorizeHttpRequests(auth -> auth.requestMatchers("http://localhost:8080/register").permitAll()
//                            .anyRequest().authenticated()
//                    );
//            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//            return http.build();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
