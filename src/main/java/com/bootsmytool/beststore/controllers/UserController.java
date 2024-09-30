package com.bootsmytool.beststore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bootsmytool.beststore.models.UserDto;
import com.bootsmytool.beststore.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String getRegisterPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfully");
		return "register";
	}
}
