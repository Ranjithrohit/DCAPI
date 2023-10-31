package com.ranjith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.ranjith.entity.CitizenAppEntity;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DcApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DcApiApplication.class, args);
		
		CitizenAppEntity appEntity=new CitizenAppEntity();
		appEntity.setAppId(1);
		appEntity.setFullname("Ranjith");
		appEntity.setEmail("ranjith@gmail.com");
		appEntity.setPhno(7981797643L);
		appEntity.setGender("M");
		appEntity.setSsn(91L);
		
		
	}

}
