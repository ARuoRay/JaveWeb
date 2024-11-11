package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exception.RoomAlreadyExistsException;
import com.example.demo.exception.RoomException;
import com.example.demo.model.dto.RoomDto;
import com.example.demo.service.RoomService;

import jakarta.validation.Valid;



/**
 * Method URI            功能
 * --------------------------------------------------------------------
 * GET    /rooms         查詢所有會議室(多筆)
 * GET    /room/{roomId} 查詢指定會議室(單筆)
 * POST   /room          新增會議室
 * PUT    /room/{roomId} 完整修改會議室(同時修改 roomName 與 roomSize)
 * PATCH  /room/{roomId} 部分欄位修改會議室(只修改  roomName 或 roomSize etc…)
 * DETETE /room/{roomId} 刪除會議室
 * --------------------------------------------------------------------
 * */
@Controller
@RequestMapping(value = {"/room","rooms"})
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public String getRooms(Model model) {
		List<RoomDto> roomDtos=roomService.getAllRooms();
		model.addAttribute("roomDtos",roomDtos);
		
		return"room";
	}
	
	@PostMapping
	public String addRoom(@Valid @ModelAttribute RoomDto roomDto,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("roomDtos",roomService.getAllRooms());
			return"room";
		}
		roomService.addRoom(roomDto);
		return"redirect:/rooms";
	}
	
	@GetMapping("/delete/{roomId}")
	public String deleteRoom(@PathVariable("roomId")Integer roomId) {
		roomService.deleteRoom(roomId);
		return"redirect/rooms";
	}
	
	@ExceptionHandler({RoomException.class})
	public String handleRoomException(RoomException e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
	
}
