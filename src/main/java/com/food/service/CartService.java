package com.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.dto.CartDto;
import com.food.dto.CartItemDto;

@Service
public interface CartService {

//	CartDto createCart(CartDto cartDto);

	CartDto createOrUpdateCart(int userId);
//	CartDto updateCart(CartDto cartDto, Long id);
	CartItemDto addItemToCart(int cartId, int menuItemId, int quantity);

	List<CartDto> getAllCart();

	CartDto getCartById(Long id);

	void deleteCart(Long id);

}
