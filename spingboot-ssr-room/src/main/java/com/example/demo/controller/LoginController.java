package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.UserCert;
import com.example.demo.service.CertService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	private CertService certService;
	
	@GetMapping
	public String loginPage() {
		return"login";
	}
	
	@PostMapping
	public String checkLogin(@RequestParam String username,@RequestParam String password,HttpSession session,HttpServletRequest req,Model model) {
			UserCert userCert=null;
			
			try {
				userCert=certService.getCert(username, password);
			}catch(Exception e) {
				model.addAttribute("message",e.getMessage());
				return"error";
			}
			session.setAttribute("userCert", userCert);
			session.setAttribute("locale", req.getLocale());
			return "redirect:/rooms";
		
	}
}
