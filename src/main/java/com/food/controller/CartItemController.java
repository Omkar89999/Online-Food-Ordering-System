package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/updateCart/{id}")
	public ResponseEntity<CartItemDto> updateCartItem(@RequestBody CartItemDto cartItemDto, @PathVariable Long id){
		
		CartItemDto updateCartItem = this.cartItemService.updateCartItem(cartItemDto, id);
		return new ResponseEntity<CartItemDto>(updateCartItem,HttpStatus.OK);
	}
	
	@GetMapping("/getCartItem/{id}")
	public ResponseEntity<CartItemDto>getCartItemById(@PathVariable Long id){
		CartItemDto cartItemById = this.cartItemService.getCartItemById(id);
		return new ResponseEntity<CartItemDto>(cartItemById,HttpStatus.OK);
	}
	@GetMapping("/getAllCartItem")
	public ResponseEntity<List<CartItemDto>>getAllCartItem(){
		List<CartItemDto> allCartItem = this.cartItemService.getAllCartItem();
		return new ResponseEntity<List<CartItemDto>>(allCartItem,HttpStatus.OK);
	}
	
}
