package com.example.demo.model.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
	@Id
	@Column(name = "Id")
	private Integer Id;
	
	@Column(name ="send_user_Id" )
	private Integer SendUserId;
	
	@Column(name ="receive_user_Id" )
	private Integer ReceiveUserId;
	
	@Column(name ="message" )
	private String Message;
	
	@Column(name ="update_time" )
	private Date UpdateTime;
}
