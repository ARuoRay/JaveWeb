package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//Springboot啟動前完成前優先啟動

public class ModelMapperConfig {
	
	@Bean//Springboot管理的物件(IOC)
	ModelMapper modelMapper() {
		return new ModelMapper();
	} 
}
