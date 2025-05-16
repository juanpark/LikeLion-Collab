package com.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.jdbc.core.JdbcTemplate; // common/JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource; // DB연결 속성 정보를 가진 객체 

import javax.sql.*;

@Configuration
@ComponentScan(basePackages="com.person")
@PropertySource("classpath:db.properties")
public class AppConfig {

	@Bean
	public DataSource dataSource(org.springframework.core.env.Environment env) {
	    DriverManagerDataSource ds = new DriverManagerDataSource();
	    ds.setDriverClassName(env.getProperty("jdbc.driver"));
	    ds.setUrl(env.getProperty("jdbc.url"));          
	    ds.setUsername(env.getProperty("jdbc.user"));   
	    ds.setPassword(env.getProperty("jdbc.password"));
	    return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
