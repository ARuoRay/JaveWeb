package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.RoomMapper;
import com.example.demo.model.dto.RoomDto;
import com.example.demo.model.entity.Room;

@SpringBootTest
class SpingbootSsrRoomApplicationTests {

		@Autowired
		private RoomMapper roomMapper;
		
		@Test
		
		void testRoomMapper() {
		//Entity測試
		Room room=new Room(101,"101(S)",4);
		System.out.println("原始 room"+room);
		
		//toDto測試
		RoomDto roomDto=roomMapper.toDto(room);
		System.out.println("測試Dto"+roomDto);
		
		//toEntity測試
		room=roomMapper.toEntity(roomDto);
		System.out.println("測試toEntity"+room);
		
		}
		

	
}
