package com.example.demo.model.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {
//	private Integer userId; // 使用者ID

	private String username; // 使用者名稱

	private String nickname;//使用者暱稱
	
	private String sex; // 使用者性別

	private String email; // 電子郵件

	private Boolean active; // 帳號啟動
}
