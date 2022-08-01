package com.dongnae.jjabpang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 *packageName    : com.dongnae.jjabpang.config
 * fileName       : AppConfig
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */
@Configuration
public class AppConfig {
      /**
       * 패스워드 인코더 - 패스워드 암호화 설정
       */
      @Bean
      public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
      }
}
