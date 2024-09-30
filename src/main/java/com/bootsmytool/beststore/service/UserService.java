package com.bootsmytool.beststore.service;

import com.bootsmytool.beststore.models.User;
import com.bootsmytool.beststore.models.UserDto;

public interface UserService {
	
	User save (UserDto userDto);

}
