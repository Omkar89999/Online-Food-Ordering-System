package com.food.service;

import org.springframework.stereotype.Service;

import com.food.dto.CartDto;
import com.food.dto.CartItemDto;

@Service
public interface CartService {


	CartDto createOrUpdateCart(long userId);

	CartItemDto addItemToCart(long cartId, long menuItemId, long quantity);
	
	double calculatePrice(long menuItemId, long quantity);
	
	void removeItemFromCart(long cartItemId);

	CartDto getCartByUserId(long userId);
	

	
	
	

}
