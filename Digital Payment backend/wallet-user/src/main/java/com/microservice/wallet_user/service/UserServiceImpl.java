package com.microservice.wallet_user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.wallet_user.constants.AppConstants;
import com.microservice.wallet_user.dto.UserDto;
import com.microservice.wallet_user.entity.User;
import com.microservice.wallet_user.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Value("${promo.amount}")
	private float promoAmount;
	
	@Autowired
	private KafkaTemplate<String, String> kafka;
	@Override
	public User registerUser(UserDto userDto) throws JsonProcessingException {
		// TODO Auto-generated method stub
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setWalletBalance(promoAmount);
		User userSaved = userRepo.save(user);
		//notifying the user via mail
		sendNotification(userDto);
		
		return userSaved;
	}
	
	private void sendNotification(UserDto userDto) throws JsonProcessingException {
			
		ObjectMapper object = new ObjectMapper();
			
			String json = object.writeValueAsString(userDto);
			kafka.send(AppConstants.NEW_USER, userDto.getUserName(), json);
			
		
	}
	
}