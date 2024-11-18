package com.food.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.CartItemDto;
import com.food.entity.CartItem;
import com.food.repo.CartItemRepo;
import com.food.repo.CartRepo;
import com.food.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepo cartItemRepo;

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CartItemDto addCartItem(CartItemDto cartItemDto) {
		CartItem cartItem = modelMapper.map(cartItemDto, CartItem.class);
        CartItem savedCartItem = cartItemRepo.save(cartItem);
        return modelMapper.map(savedCartItem, CartItemDto.class);
	}

	@Override
	public List<CartItemDto> getCartItemsByCartId(long cartId) {
		 List<CartItem> cartItems = cartItemRepo.findByCartId(cartId);
	        return cartItems.stream()
	                .map(cartItem -> modelMapper.map(cartItem, CartItemDto.class))
	                .collect(Collectors.toList());
	}

	@Override
	public Optional<CartItemDto> getCartItemById(long id) {
		Optional<CartItem> cartItem = cartItemRepo.findById(id);
        return cartItem.map(item -> modelMapper.map(item, CartItemDto.class));
	}

	@Override
	public CartItemDto updateCartItemQuantity(long id, long quantity) {
		CartItem cartItem = cartItemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        cartItem.setQuantity(quantity);
        // Update the price if necessary
        cartItem.setPrice(cartItem.getPrice() * quantity);
        CartItem updatedCartItem = cartItemRepo.save(cartItem);
        return modelMapper.map(updatedCartItem, CartItemDto.class);
	}

	@Override
	public void removeCartItem(long id) {
		cartItemRepo.deleteById(id);
		
	}
	
	

}
