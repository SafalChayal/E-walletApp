package com.microservice.wallet_user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.wallet_user.dto.UserDto;
import com.microservice.wallet_user.entity.User;
import com.microservice.wallet_user.service.UserService;

@RestController
public class UserApi {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) throws JsonProcessingException{
		
		User user = userService.registerUser(userDto);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
		
	}
}