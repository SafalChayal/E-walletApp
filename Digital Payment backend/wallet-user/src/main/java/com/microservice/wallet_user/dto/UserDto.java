package com.microservice.wallet_user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

	private String userName;
	@NotBlank
	private String password;
	@Email(message = "Please provide valid mail Id")
	@NotBlank(message = "Email cannot be blank")
	private String email;
}