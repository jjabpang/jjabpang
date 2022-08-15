package com.dongnae.jjabpang;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableJpaAuditing
public class JjabpangApplication {
      
      public static final String APPLICATION_LOCATIONS = "spring.config.location="
                                                         + "classpath:application.yml";
      
      public static void main(String[] args) {
            new SpringApplicationBuilder(JjabpangApplication.class).properties(APPLICATION_LOCATIONS)
                                                                   .run(args);
            
      }
      
      @Bean
      public InternalResourceViewResolver defaultViewResolver() {
            return new InternalResourceViewResolver();
      }
}
