package com.projects.bookmarkmanager;

import com.projects.bookmarkmanager.repository.MetaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookmarkManagerApplication {

    private final MetaRepository metaRepository;

    public BookmarkManagerApplication(MetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookmarkManagerApplication.class, args);
    }


    @Bean
    public ServletRegistrationBean<GraphServlet> graphqlServlet() {
        // serve the graphql api on /graphql/
        ServletRegistrationBean<GraphServlet> bean = new ServletRegistrationBean<>(
                new GraphServlet(metaRepository), "/graphql/*");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
