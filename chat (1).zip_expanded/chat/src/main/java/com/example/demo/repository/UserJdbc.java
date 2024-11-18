package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Entity.User;

public interface UserJdbc {
	List<User> findAllUser(); //多筆:搜尋所有資料
	
	Optional <User> findByUserName(String username); //單筆:搜尋某人資料
	
	int saveUser(User user); //增加會員
	
	int updateUser(User user); //修改會員資料
	
	int deleteUser(String UserName); //刪除會員
	
	int updatePasswordHash(User user); //修改密碼
	
	//int updateRole(User user); //修改權限
}
