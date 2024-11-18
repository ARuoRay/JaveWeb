package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PasswordInvalidException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Dto.UserDto;
import com.example.demo.model.Entity.User;
import com.example.demo.repository.UserJdbc;
import com.example.demo.repository.Impl.UserJdbcImpl;
import com.example.demo.service.UserService;
import com.example.demo.util.Hash;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserJdbcImpl userJdbcImpl;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDto> getAllUser() {
		return userJdbcImpl.findAllUser() //List<User>
						   .stream()
						   .map(userMapper::toDto)
						   .collect(Collectors.toList());
	}

	@Override
	public UserDto getUserByUserName(String username) throws UserNotFoundException {
		User user=userJdbcImpl.findByUserName(username)
				.orElseThrow(()->new UserNotFoundException("會員不存在"));
		return userMapper.toDto(user);
	}

	@Override
	public void addUser(String username, String password, String nickName, String sex, String email) throws UserNotFoundException {
		Optional<User> optUser=userJdbcImpl.findByUserName(username);
		if(optUser.isPresent()) { //會員存在
			throw new UserNotFoundException("已經有此會員，新增失敗");
		}
		String salt=Hash.getSalt();
		String passwordHash=Hash.getHash(password, salt);
		User user = new User(username, passwordHash, salt, nickName, sex, email);
		userJdbcImpl.saveUser(user);
	}

	@Override
	public void updateUser( String username,String nickName, String email) {
		if(!nickName.isEmpty()||!email.isEmpty()) {
			User user= new User(username,nickName,email);
			userJdbcImpl.updateUser(user);
		}
		
	}

	@Override
	public void deleteUser(String username) throws UserNotFoundException {
		Optional<User> optUser=userJdbcImpl.findByUserName(username);
		if(optUser.isEmpty()) {
			throw new UserNotFoundException("會員不存在，刪除失敗");
		}
		userJdbcImpl.deleteUser(username);
	}

	@Override
	public void updatePasswordHash( String username, String oldPassword, String newPassword) throws PasswordInvalidException, UserNotFoundException  {
		Optional<User> optUser=userJdbcImpl.findByUserName(username);
		if(optUser.isEmpty()) {
			throw new UserNotFoundException(username+"會員不存在");
		}
		String salt=optUser.map(User::getSalt).orElse("");
	//	System.out.println(salt);
		String oldPasswordHash=Hash.getHash(oldPassword,salt);
	//	System.out.println(oldPasswordHash);
		
		// 比對修改之前的 password 是否正確 
		String passwordHash=optUser.map(User::getPasswordHash).orElse("");
	//	System.out.println(passwordHash);
		if(!oldPasswordHash.equals(passwordHash)) {
			throw new PasswordInvalidException("原密碼輸入錯誤");
		}
		
		// 產生新密碼的 Hash
		String newPasswordHash = Hash.getHash(newPassword, salt);
		// 密碼 Hash 修改
		User user=new User(username,newPasswordHash);
		userJdbcImpl.updatePasswordHash(user);
	}
}
