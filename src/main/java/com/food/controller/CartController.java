package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.CartDto;
import com.food.dto.CartItemDto;
import com.food.service.CartService;

@RestController
@RequestMapping("/online/food/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	// Endpoint to create or update a cart for a specific user
    @PostMapping("/user/{userId}")
    public ResponseEntity<CartDto>createOrUpdateCart(@PathVariable long userId) {
    	
    	CartDto cart = cartService.createOrUpdateCart(userId);
        return new ResponseEntity<CartDto>(cart,HttpStatus.CREATED);
    }
	
    @PostMapping("/addItem")
    public ResponseEntity<CartItemDto> addItemToCart(
            @RequestParam long cartId, @RequestParam long menuItemId, @RequestParam long quantity) {
        CartItemDto cartItem = cartService.addItemToCart(cartId, menuItemId, quantity);
        return ResponseEntity.ok(cartItem);
    }

    // Endpoint to remove an item from the cart
    @DeleteMapping("/removeItem")
    public ResponseEntity<String> removeItemFromCart(@RequestParam long cartItemId) {
        cartService.removeItemFromCart(cartItemId);
        return ResponseEntity.ok("Cart item removed successfully");
    }

    // Endpoint to get the cart by userId
    @GetMapping("/{userId}")
    public ResponseEntity<CartDto> getCartByUserId(@PathVariable long userId) {
        CartDto cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }
 
	
}
