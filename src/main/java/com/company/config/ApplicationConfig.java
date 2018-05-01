package com.company.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.company")
public class ApplicationConfig implements WebMvcConfigurer{

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	      dataSource.setUsername( "mathan" );
	      dataSource.setPassword( "root" );
	      return dataSource;
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(dataSource());
	}
}