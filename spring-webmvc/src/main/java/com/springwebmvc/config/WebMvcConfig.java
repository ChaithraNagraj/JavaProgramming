package com.springwebmvc.config;

import org.springframework.config.java.plugin.context.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springwebmvc.repositry.UserDao;
import com.springwebmvc.repositry.UserDaoImpl;
@Configuration
@EnableWebMvc  //bcz i want to use annotation config,it will use annotation everywhere
@ComponentScan("com.springwebmvc.controller")
public class WebMvcConfig 
{
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;

	}
	
	@Bean
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bridgelabzdatabase");
		ds.setUsername("root");
		ds.setPassword("Harshi@1");
		return ds;
	}
	
	@Bean
	public UserDao getUserDao()
	{
		return new UserDaoImpl(getDataSource());
		
	}
	
	
}
