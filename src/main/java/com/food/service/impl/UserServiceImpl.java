package com.food.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.food.dto.UserDto;
import com.food.entity.Role;
import com.food.entity.User;
import com.food.payloads.AppConstant;
import com.food.repo.RoleRepo;
import com.food.repo.UserRepo;
import com.food.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);
		User savedUser = this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		User users = this.userRepo.findById(id).orElseThrow();

		users.setUsername(userDto.getUsername());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		User updatedUser = this.modelMapper.map(users, User.class);

		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = this.userRepo.findById(id).orElseThrow();

		return this.modelMapper.map(user, UserDto.class);

	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> allUser = this.userRepo.findAll();

		return allUser.stream()
				.map(user -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Long id) {
		User user = this.userRepo.findById(id).orElseThrow();

		userRepo.delete(user);

	}

	// register new user method

	@Override
	public UserDto registerNewUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role role = roleRepo.findById(AppConstant.ROLE_NORMAL).get();

		user.getRole().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

	// login user with the help of token

	// public JwtAuthResponse authenticate(String username, String password) throws
	// AuthenticationException {
	// Authentication authentication = authenticationManager.authenticate(
	// new UsernamePasswordAuthenticationToken(username, password)
	// );
	//
	// String token = jwtTokenHelper.generateToken(authentication);
	// JwtAuthResponse response = new JwtAuthResponse();
	// response.setToken(token);
	//
	// return response;
	// }

}
