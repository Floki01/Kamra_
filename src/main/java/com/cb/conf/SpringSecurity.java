package com.cb.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeHttpRequests().requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .permitAll();

        // http.oauth2Login().loginPage("/login").defaultSuccessUrl("/login");

        // http.csrf().disable().authorizeHttpRequests((requests) -> requests
        //                 .requestMatchers("/register/**","/ankh", "/inicio", "/tarot", "/styles/**", "/resources/**").permitAll()
        //                 .requestMatchers("/login/**").permitAll()
        //                 .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
        //                 .requestMatchers("/admin/**").hasAnyRole("ADMIN")
        //                 .anyRequest().authenticated())
        //         .formLogin((form) -> form
        //                 .loginPage("/login")
        //                 .loginProcessingUrl("/login")
        //                 .defaultSuccessUrl("/user/")
        //                 .permitAll())
        //         .logout((logout) -> logout.permitAll())
        //         .exceptionHandling().accessDeniedPage("/access-denied");

        http.authorizeHttpRequests().
        requestMatchers("/register/**","/pepe/**","/calendar","/test/**","/ankh", "/inicio", "/tarot", "/styles/**", "/resources/**","/login/**").permitAll()
        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
        .and()
        .formLogin().loginPage("/login")
        .loginProcessingUrl("/login").defaultSuccessUrl("/user/").
        and()
        .oauth2Login().loginPage("/login");

    

        http.headers().frameOptions().disable();
        return http.build();
    }

    
}
