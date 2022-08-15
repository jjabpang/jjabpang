package com.dongnae.jjabpang.config;
/*
 *packageName    : com.dongnae.jjabpang.config
 * fileName       : WebSecurityConfig
 * author         : ipeac
 * date           : 2022-08-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-11        ipeac       최초 생성
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

// WebSecurityConfig.java
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
      private static final String[] PERMIT_URL_ARRAY = {
            /* swagger v2 */
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            /* swagger v3 */
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/profile"
      };
      
      @Override
      public void configure(WebSecurity webSecurity) throws Exception {
            // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
            webSecurity.ignoring()
                       .antMatchers("/css/**", "/js/**", "/image/**", "/lib/**");
            webSecurity.ignoring()
                       .antMatchers("/**", "/v2/api-docs", "/v3/api-docs", "/configuration/ui",
                             "/swagger-resources", "/configuration/security",
                             "/swagger-ui.html", "/webjars/**", "/swagger/**");
      }
      
      @Bean
      public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
      }
      
      @Override
      protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                  // h2-console 옵션 disable
                  .csrf()
                  .disable()
                  .headers()
                  .frameOptions()
                  .disable()
                  .and()
                  .authorizeRequests()
                  .antMatchers("/**", "/oauth2/**", "/signin/**", "/login/**", "console/**", "/api/**")
                  .permitAll()
                  .and()
                  .authorizeRequests()
                  .antMatchers(PERMIT_URL_ARRAY)
                  .permitAll()
                  // 인증된 사용자만 접근 가능
                  .anyRequest()
                  .authenticated()
                  .and()
                  .exceptionHandling()
                  // 인증 없이 페이지에 접근할 경우 리다이렉트
                  .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/signin"))
                  .and()
                  .logout()
                  .logoutSuccessUrl("/");
            
      }
      
}