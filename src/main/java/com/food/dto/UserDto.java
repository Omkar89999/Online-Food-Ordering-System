package com.food.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	@Size(min = 4, message = "Username must be min of 4 character !!")
	private String username;
	@Email(message="Email Address is not valid !!")
	private String email;
	@NotEmpty
	@Size(min = 4, message = "Password must be min of 4 char and max of 10 chars !!")
	private String password;
	
	private String role;
}
