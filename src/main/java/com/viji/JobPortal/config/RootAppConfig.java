package com.viji.JobPortal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.viji.JobPortal.model.DatabaseConnection;



@Configuration
@ComponentScan("com.viji.JobPortal")
public class RootAppConfig {
	@Bean
	public DatabaseConnection getDatabaseConnection() {
		return new DatabaseConnection();
	}
}