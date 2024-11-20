package com.example.chat.service.impl;

import java.rmi.registry.Registry;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.model.dto.Register;
import com.example.chat.model.entity.User;
import com.example.chat.repository.UserRepository;
import com.example.chat.service.UserService;
import com.example.chat.util.Hash;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void addUser(Register register) {
		//新增會員
		String salt=Hash.getSalt();
		String passwordHash=Hash.getHash(register.getPassword(), salt);
		User user=new User(register.getUsername(),passwordHash,salt,null,register.getGender(),register.getEmail());
		userRepository.save(user);
	}

}
