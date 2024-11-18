package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Springboot 在啟動完成前會先行執行此配置
public class ModelMapperConfig {

	// 由Springboot來管理此物件(IOC)
	// 其他城市可以透過 @Autowired 取得該實體
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
