package com.food.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.CartItemDto;
import com.food.dto.UserDto;
import com.food.entity.UserCart;
import com.food.entity.CartItem;
import com.food.entity.User;
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
	public CartItem createCartItem(CartItemDto cartItemDto) {

		CartItem cartItem = this.modelMapper.map(cartItemDto, CartItem.class);
		UserCart cart = this.cartRepo.findById(cartItemDto.getCart()).orElseThrow();

		cartItem.setCart(cart);
		CartItem saveCartItem = cartItemRepo.save(cartItem);

		return saveCartItem;
	}

	@Override
	public CartItemDto updateCartItem(CartItemDto cartItemDto, Long id) {
		CartItem cartItem = this.cartItemRepo.findById(id).orElseThrow();
		cartItem.setCart(cartItemDto.getCart());
		cartItem.setMenuItem(cartItemDto.getMenuItem());
		cartItem.setQuantity(cartItemDto.getQuantity());
		cartItem.setPrice(cartItemDto.getPrice());
		CartItem updatedItem = cartItemRepo.save(cartItem);

		return this.modelMapper.map(updatedItem, CartItemDto.class);
	}

	@Override
	public List<CartItemDto> getAllCartItem() {
		List<CartItem> allCartItem = this.cartItemRepo.findAll();

		return allCartItem.stream().map(cartItem -> this.modelMapper.map(cartItem, CartItemDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public CartItemDto getCartItemById(Long id) {

		CartItem cartItem = cartItemRepo.findById(id).orElseThrow();
		return modelMapper.map(cartItem, CartItemDto.class);
	}

	@Override
	public void deleteCartItem(Long id) {
		CartItem cartItem = cartItemRepo.findById(id).orElseThrow();
		this.cartItemRepo.delete(cartItem);

	}

}
