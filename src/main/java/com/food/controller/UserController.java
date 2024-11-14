package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.UserDto;
import com.food.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/online/food")
public class UserController {

	// url pattern
	// http://localhost:8080/online/food/...
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private TokenService tokenService;
	
	// Create User
	@PostMapping("/create")
	public ResponseEntity<UserDto>createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto user = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);
	}
	
	// Update User
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto, @PathVariable Long id){
		
		UserDto updateUser = this.userService.updateUser(userDto, id);
		return ResponseEntity.ok(updateUser);
		
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<List<UserDto>>getAllUser(){
	
		 return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserDto>getById(@PathVariable Long id){
		
		UserDto user = this.userService.getUserById(id);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	
	// delete user
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		this.userService.deleteUser(id);
	}
	
}
