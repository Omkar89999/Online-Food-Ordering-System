package com.food.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.CartDto;
import com.food.repo.CartRepo;
import com.food.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CartDto createCart(CartDto cartDto) {
		
		
		return null;
	}

	@Override
	public CartDto updateCart(CartDto cartDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartDto> getAllCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDto getCartById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(Long id) {
		// TODO Auto-generated method stub
		
	}

}
 