package com.SpringJdbcCrud;

import org.SpringJdbcCrud.view.EmployeeFrame;
import org.SpringJdbcCrud.view.LoginFrame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"com.SpringJdbcCrud.Dao" , "com.SpringJdbcCrud.Entity" , "org.SpringJdbcCrud.view"})
public class JavaConfig {
	
	@Bean("dSource")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource dSource = new DriverManagerDataSource();
		dSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dSource.setUrl("jdbc:mysql://localhost:3306/springJdbc");
		dSource.setUsername("root");
		dSource.setPassword("Om/525325..??");
		
		return dSource;
	}
	@Bean(name = {"jdbcTemplate","template"})
	 public JdbcTemplate getJdbcTemplate() {
		 
		JdbcTemplate template = new JdbcTemplate(getDataSource());
		return template;
	}
	
	@Bean(name = {"frame","loginFrame"})
	public LoginFrame getLoginFrame() {
		
		LoginFrame loginFrame = new LoginFrame();
		return loginFrame;
	}
	
	@Bean("empFrame")
	public EmployeeFrame getEmployeeFrame() {
		EmployeeFrame employeeFrame = new EmployeeFrame();
		return employeeFrame;
	}

}
