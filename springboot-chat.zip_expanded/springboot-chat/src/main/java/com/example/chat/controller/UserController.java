package com.example.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.model.dto.Register;
import com.example.chat.model.entity.User;
import com.example.chat.response.ApiResponse;
import com.example.chat.service.UserService;

@RestController
@RequestMapping("/Register")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	// 新增會員
	@PostMapping
	public ResponseEntity<ApiResponse<Register>> createUser(@RequestBody Register register) {
		System.out.println(register.toString());
		userService.addUser(register);
		return ResponseEntity.ok(ApiResponse.success("新增成功", null));
	}

	// 處理異常狀況
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse<Void>> handleTodoRuntimeException(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ApiResponse.error(HttpStatus.NOT_FOUND.value(), e.getMessage()));
	}
}
