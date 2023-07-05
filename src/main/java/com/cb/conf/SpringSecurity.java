package com.cb.conf;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity{

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeHttpRequests().requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .permitAll();

        http.authorizeHttpRequests().
        requestMatchers("/register/**","/calendar","/test/**","/rest/**","/ankh", "/inicio", "/tarot", "/panel", "/agenda" ,"/agenda/**", "/styles/**","/js/**", "/resources/**","/login/**").permitAll()
        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
        .and()
        .formLogin().loginPage("/login")
        .loginProcessingUrl("/login").defaultSuccessUrl("/user/").successHandler((request, response, authentication) -> {
            // Obtener los roles del usuario autenticado
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            // Verificar si el usuario tiene el rol de ADMIN
            boolean isAdmin = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

            if (isAdmin) {
                response.sendRedirect("/admin/"); // Redirigir a la página de destino para roles ADMIN
            } else {
                response.sendRedirect("/user/"); // Redirigir a la página de destino para roles USER
            }
        });

    

        http.headers().frameOptions().disable();
        return http.build();
    }

    
}
