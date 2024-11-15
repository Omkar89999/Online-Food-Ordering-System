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

import com.food.dto.CartDto;
import com.food.service.CartService;

@RestController
@RequestMapping("/online/food/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/addCart")
	public ResponseEntity<CartDto> addCartItem(@RequestBody CartDto cartDto){
		
		CartDto cart = cartService.createCart(cartDto);
		
		return new ResponseEntity<CartDto>(cart,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCart/{id}")
	public ResponseEntity<CartDto> updateCart(@RequestBody CartDto cartDto, @PathVariable Long id){
		
		CartDto updatedCart = this.cartService.updateCart(cartDto, id);
		return new ResponseEntity<CartDto>(updatedCart,HttpStatus.OK);
	}
	
	@GetMapping("/getCart/{id}")
	public ResponseEntity<CartDto>getCartById(@PathVariable Long id){
		CartDto cartById = this.cartService.getCartById(id);
		return new ResponseEntity<CartDto>(cartById,HttpStatus.OK);
	}
	@GetMapping("/getAllCart")
	public ResponseEntity<List<CartDto>>getAllCart(){
		List<CartDto> allCart = this.cartService.getAllCart();
		return new ResponseEntity<List<CartDto>>(allCart,HttpStatus.OK);
	}
	
}
