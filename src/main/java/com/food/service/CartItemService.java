package com.food.service;

import java.util.List;

import com.food.dto.CartItemDto;
import com.food.entity.CartItem;

public interface CartItemService {
	
	CartItem createCartItem(CartItemDto cartItemDto);
	
	CartItemDto updateCartItem(CartItemDto cartItemDto, Long id);
	
	List<CartItemDto> getAllCartItem();
	
	CartItemDto getCartItemById(Long id);
	
	void deleteCartItem(Long id);
	

}
