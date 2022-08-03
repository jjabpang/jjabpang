package com.dongnae.jjabpang.config;
/*
 *packageName    : com.dongnae.jjabpang.config
 * fileName       : SwaggerConfig
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
      
      private ApiInfo swaggerInfo() {
            return new ApiInfoBuilder().title("jjabpang")
                                       .description("jjabpang docs")
                                       .build();
      }
      
      @Bean
      public Docket swaggerApi() {
            return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes())
                                                          .produces(getProduceContentTypes())
                                                          .apiInfo(swaggerInfo())
                                                          .select()
                                                          .apis(RequestHandlerSelectors.basePackage("com.dongnae.jjabpang.controller"))
                                                          .paths(PathSelectors.any())
                                                          .build()
                                                          .useDefaultResponseMessages(false);
      }
      
      private Set<String> getConsumeContentTypes() {
            Set<String> consumes = new HashSet<>();
            consumes.add("application/json;charset=UTF-8");
            consumes.add("application/x-www-form-urlencoded");
            return consumes;
      }
      
      private Set<String> getProduceContentTypes() {
            Set<String> produces = new HashSet<>();
            produces.add("application/json;charset=UTF-8");
            return produces;
      }
}
      
