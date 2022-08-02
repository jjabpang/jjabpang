package com.dongnae.jjabpang.config;
/*
 *packageName    : com.dongnae.jjabpang.config
 * fileName       : QueryDslConfig
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslConfig {
      
      @PersistenceContext
      private EntityManager entityManager;
      
      @Bean
      public JPAQueryFactory jpaQueryFactory() {
            return new JPAQueryFactory(entityManager);
      }
}
