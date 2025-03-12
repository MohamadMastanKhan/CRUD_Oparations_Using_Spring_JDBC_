package com.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Springconfig
{
	@Bean
	public DriverManagerDataSource myDatasource()
	{
		DriverManagerDataSource dr=new DriverManagerDataSource();
		dr.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dr.setUrl("jdbc:mysql://localhost:3307/springjdbc");
		dr.setUsername("root");
		dr.setPassword("root");
		return dr;
	}
	
	@Bean
	public JdbcTemplate myJdbcTemplate()
	{
		JdbcTemplate jd=new JdbcTemplate();
		jd.setDataSource(myDatasource());
		return jd;
	}
	
}
