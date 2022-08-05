package com.dongnae.jjabpang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableJpaAuditing
public class JjabpangApplication {
      
      public static void main(String[] args) {
            SpringApplication.run(JjabpangApplication.class, args);
      }
      
      @Bean
      public InternalResourceViewResolver defaultViewResolver() {
            return new InternalResourceViewResolver();
      }
}
