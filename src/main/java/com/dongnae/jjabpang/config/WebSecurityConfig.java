package com.dongnae.jjabpang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 *packageName    : com.dongnae.jjabpang.config
 * fileName       : WebSeurityConfig
 * author         : ipeac
 * date           : 2022-08-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-11        ipeac       최초 생성
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
      // 암호화에 필요한 PasswordEncoder 를 Bean 등록합니다.
      @Bean
      public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
      }
      
      // authenticationManager를 Bean 등록합니다.
      @Bean
      @Override
      public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
      }
      
      @Override
      protected void configure(HttpSecurity http) throws Exception {
            http.csrf()
                .disable();
            http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .hasRole("USER")
                .antMatchers("/**")
                .permitAll();
      }
}
