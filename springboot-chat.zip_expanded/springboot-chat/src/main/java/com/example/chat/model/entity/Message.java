package com.example.chat.model.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false )
	private String message;
	
	@Column(nullable = false,updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private LocalDateTime createAt; //創建時間
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "username")
	private User sendUser;
	
	@ManyToOne
	@JoinColumn(referencedColumnName ="chatId")
	private Chat receiveChat;
	
	@PrePersist
    public void prePersist() {
        this.createAt = LocalDateTime.now();
    }
}
