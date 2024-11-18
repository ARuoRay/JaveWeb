package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.exception.PasswordInvalidException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Entity.User;
import com.example.demo.repository.Impl.UserJdbcImpl;
import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.util.Hash;

@SpringBootTest
public class UserTests {

	@Autowired
	private UserJdbcImpl userJdbcImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl; 
	
	
/*	@Test //資料層:新增
	public void UserAdd() throws UserNotFoundException {
		User user=new User("usually12336","seldom12336",Hash.getSalt(),"nick","男","usually12336@gmail.com");
		int row=userJdbcImpl.saveUser(user);
		if(row==1) {
			System.out.println("成功");
		}
	}*/

/*	@Test //資料層:多筆查詢
	public void Userfind() throws UserNotFoundException {
		System.out.println("多筆查詢:"+userJdbcImpl.findAllUser());
	}*/
	
/*	@Test //資料層:單筆查詢
	public void Userfind() throws UserNotFoundException {
		System.out.println("單筆查詢:"+userJdbcImpl.findByUserName("usually12336"));
	}*/
	
/*	@Test //資料層:修改
	public void UserAdd() throws UserNotFoundException {
		User user =new User("usually","翁","usually12336@gmail.com");
		int row=userJdbcImpl.updateUser(user);
		if(row==1) {
			System.out.println("成功");
		}
	}*/
	
/*	@Test //資料層:刪除
	public void UserAdd() throws UserNotFoundException {
		int row=userJdbcImpl.deleteUser("usually12336");
		if(row==1) {
			System.out.println("成功");
		}
	}*/
	
	
/*		@Test  //服務層:新增
	public void UserAdd() throws UserNotFoundException {
		userServiceImpl.addUser("usually12336","seldom12336","nick","男","usually12336@gmail.com");
	}*/

/*	@Test  //服務層:多筆查詢
	public void UserAdd() throws UserNotFoundException {
		System.out.println("單筆查詢:"+userServiceImpl.getAllUser());
	}*/
	
	/*@Test  //服務層:單筆查詢
	public void Userfind() throws UserNotFoundException {
		System.out.println("單筆查詢:"+userServiceImpl.getUserByUserName("usually12336").toString());
	}*/
	
/*	@Test //服務層:刪除
	public void UserAdd() throws UserNotFoundException {
		userServiceImpl.deleteUser("usually12336");
	}*/
	
/*	@Test //服務層:修改
	public void updateuser() {
		userServiceImpl.updateUser("usually12336","翁瑞豪","always12336@gmail.com");
	}*/
	
/*	@Test //服務層:修改密碼
	public void updatePasswordHash() throws PasswordInvalidException, UserNotFoundException {
		userServiceImpl.updatePasswordHash("usually12336","seldom12336", "never12336");
	}*/
}
