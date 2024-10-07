package com.bootsmytool.beststore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bootsmytool.beststore.models.User;
import com.bootsmytool.beststore.models.UserDto;
import com.bootsmytool.beststore.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname());
		//把userDto轉換成User實體，因為Dto是負責傳資料用的，實際需要更新資料庫的實體是User
		return userRepository.save(user);
	}
	
}
