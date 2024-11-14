package com.example.test.model.dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer userId; // 使用者ID
	private String username; // 使用者名稱
	private String email; // 電子郵件
	private Boolean active; // 帳號啟動
	private String role; // 角色權限
}