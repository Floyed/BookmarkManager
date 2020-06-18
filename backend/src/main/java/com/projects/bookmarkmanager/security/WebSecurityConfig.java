package com.projects.bookmarkmanager.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@PropertySource("classpath:application.yml")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${application.developerMode}")
    private boolean devMode;

    @Override
    public void configure(WebSecurity web) throws Exception {
        System.out.println(devMode+"zzzzzzzzzzzzzz");

        if (devMode) {
            configureDevMode(web);
        }

    }

    private void configureDevMode(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("**/*");
    }

}
