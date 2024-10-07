package com.bootsmytool.beststore.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bootsmytool.beststore.models.UserDto;
import com.bootsmytool.beststore.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String getRegisterPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	// Spring 會透過依賴注入機制自動將 UserServiceImplement 這個具體的實現類注入到控制器中，因為它是 UserService 介面的實現類且標記了 @Service 註解
	//這樣，在你實際使用 userService.save(userDto) 時，會執行的是 UserServiceImplement 中覆寫的 save() 方法。
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfully");
		return "register";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("user") UserDto userDto) {
		return "login";
	}
	
	@GetMapping("user-page")
	public String userPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	
	@GetMapping("admin-page")
	public String adminPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}
	
	
}
