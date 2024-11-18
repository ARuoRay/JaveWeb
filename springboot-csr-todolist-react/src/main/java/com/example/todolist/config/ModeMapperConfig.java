package com.example.todolist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModeMapperConfig {
	
	@Bean
	//@Scope("singleton")單一
	//@Scope("prototype")多實體
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
