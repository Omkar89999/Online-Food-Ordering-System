package com.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.dto.UserDto;

@Service
public interface UserService {

	// create user
	UserDto createUser(UserDto userDto);
	
	// register new user
	UserDto registerNewUser(UserDto userDto);

	// update user
	UserDto updateUser(UserDto userDto, Long id);

	// get user by using id
	UserDto getUserById(Long id);

	// get all user
	List<UserDto> getAllUser();

	// delete user by using id
	void deleteUser(Long id);
}
