package com.projects.bookmarkmanager.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;
import java.util.List;


@PropertySource("classpath:application.yml")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${application.developerMode}")
    private boolean devMode;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        System.out.println(devMode+"zzzzzzzzzzzzzz");

        if (devMode) {
            configureDevMode(http);
        }

    }

    private void configureDevMode(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("**/*")
//                .permitAll();

        http
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable().authorizeRequests()
                .antMatchers("**/*").hasIpAddress("127.0.0.1");
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // TODO: add the deployed website to this list
        configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:8080"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
