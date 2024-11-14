package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.CartItemDto;
import com.food.entity.CartItem;
import com.food.service.CartItemService;

@RestController
@RequestMapping("/online/food/cartItem")
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;
	@PostMapping("/addCart")
	public ResponseEntity<CartItemDto> addCartItem(@RequestBody CartItemDto cartItemDto){
		
		CartItem cartItem = cartItemService.createCartItem(cartItemDto);
		return new ResponseEntity(cartItem,HttpStatus.CREATED);
	}
}
