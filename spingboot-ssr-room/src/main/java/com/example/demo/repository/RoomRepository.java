package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Room;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	List<Room> findByRoomSizeGreaterThan(Integer size);
	
	@Query("select r from Room r where r.roomSize >:size")
	List<Room> findByRoomSizeGreaterThan1(Integer size);
	
	@Query(value="select room_id,room_name,room_size from room where room_size>:size", nativeQuery = true )
	List<Room> findByRoomSizeGreaterThan2(Integer size);
}
