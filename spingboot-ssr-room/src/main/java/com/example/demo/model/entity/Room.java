package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  Table name: room
  +---------+-----------+-----------+
  | room_id | room_name | room_size |
  +---------+-----------+-----------+
  |  101    |  101(L)   |   100     |  
  +---------+-----------+-----------+
  
  SQL:
  create table room(
  	room_id integer primary key,
  	room_name varchar(50) not null unique,
  	room_size int default 0
  );
  
  
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="room")
public class Room {

	@Id
	//room_id 自動生成, 從 1 開始每次自動 +1 過號不補
    //@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="room_id")
	private Integer roomId;
	
	@Column(name="room_name",nullable = false,unique = true)
	private String roomName;
	
	@Column(name = "room_size",columnDefinition = "integer default 0")
	private Integer roomSize;
}
