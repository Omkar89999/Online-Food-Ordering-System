package com.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.dto.CartDto;

@Service
public interface CartService {

	CartDto createCart(CartDto cartDto);

	CartDto updateCart(CartDto cartDto, Long id);

	List<CartDto> getAllCart();

	CartDto getCartById(Long id);

	void deleteCart(Long id);

}
