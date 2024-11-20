package com.example.chat.service;

import com.example.chat.model.dto.Register;
import com.example.chat.model.entity.User;

public interface UserService {
	//註冊會員
	public void addUser(Register register);
}
