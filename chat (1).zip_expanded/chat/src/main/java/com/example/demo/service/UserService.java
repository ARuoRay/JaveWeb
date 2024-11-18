package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.PasswordInvalidException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Dto.UserDto;

public interface UserService {
	List<UserDto>  getAllUser(); //查詢所有會員
	UserDto getUserByUserName(String username) throws UserNotFoundException;//查詢單一會員
	void addUser(String username, String password,String nickName,String sex,String email) throws UserNotFoundException;//新增會員
	void updateUser(String username,String nickName,String email);//修改會員
	void deleteUser(String username) throws UserNotFoundException;//刪除會員
	void updatePasswordHash( String username, String oldPassword, String newPassword) throws PasswordInvalidException,UserNotFoundException;//修改密碼
}
