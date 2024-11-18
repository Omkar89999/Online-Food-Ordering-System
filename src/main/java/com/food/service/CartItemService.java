package com.food.service;

import java.util.List;
import java.util.Optional;

import com.food.dto.CartItemDto;

public interface CartItemService {
	

	CartItemDto addCartItem(CartItemDto cartItemDto);
    List<CartItemDto> getCartItemsByCartId(long cartId);
    Optional<CartItemDto> getCartItemById(long id);
    CartItemDto updateCartItemQuantity(long id, long quantity);
    void removeCartItem(long id);
	

}
