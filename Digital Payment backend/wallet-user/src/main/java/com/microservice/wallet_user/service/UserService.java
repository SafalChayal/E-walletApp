package com.microservice.wallet_user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.wallet_user.dto.UserDto;
import com.microservice.wallet_user.entity.User;

public interface UserService {
	
	User registerUser(UserDto userDto) throws JsonProcessingException;
	
}
