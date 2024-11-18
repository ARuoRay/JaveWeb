package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Dto.MessageDto;
import com.example.demo.model.Entity.Message;

public class MessageMapper {

	@Autowired
	private ModelMapper modelMapper;

	public MessageDto toDto(Message message) {
		return modelMapper.map(message,MessageDto.class);
	}

	public Message toEntity(MessageDto messageDto) {
		return modelMapper.map(messageDto,Message.class);
	}
}
