package com.dongnae.jjabpang.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.dongnae.jjabpang.config
 * fileName       : AppConfig
 * author         : jihye94
 * date           : 2022-08-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-06        jihye94       최초 생성
 */
@Configuration
public class AppConfig {
      @Bean
      public ModelMapper modelMapper() {
            return new ModelMapper();
      }
}
