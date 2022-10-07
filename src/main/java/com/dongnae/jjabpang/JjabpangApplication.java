package com.dongnae.jjabpang;

import com.dongnae.jjabpang.aop.SelectLogAspect;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableBatchProcessing
@SpringBootApplication
@EnableJpaAuditing
public class JjabpangApplication {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JjabpangApplication.class, args);
        
    }
    
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
    
    @Bean
    public SelectLogAspect selectLogAspect() {
        return new SelectLogAspect();
    }
}
