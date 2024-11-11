package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.RoomDto;
import com.example.demo.model.entity.Room;

@Component //元件自動掃描後管理
public class RoomMapper {

	@Autowired
	private ModelMapper modelMapper;
	
//	private ModelMapper modelMapper;
//	
//	@Autowired
//	public RoomMapper(ModelMapper modelMapper) {
//		//..
//		this.modelMapper=modelMapper;
//	}
//	
	public RoomDto toDto(Room room) {
		//Enitty to Dto
		return modelMapper.map(room, RoomDto.class);
	}
	
	public Room toEntity(RoomDto roomDto) {
		//Dto to Enitty
		return modelMapper.map(roomDto, Room.class);
	}
}
