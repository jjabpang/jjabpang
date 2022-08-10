package com.dongnae.jjabpang.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/*
 *packageName    : com.dongnae.jjabpang.config
 * fileName       : MybatisConfig
 * author         : ipeac
 * date           : 2022-08-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-10        ipeac       최초 생성
 */
@Configuration
@MapperScan(value = "com.dongnae.jjabpang.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {
      @Bean(name = "sqlSessionFactory")
      public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*-mapper.xml"));
            return sqlSessionFactoryBean.getObject();
      }
}
