package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.CartItemDto;
import com.food.service.CartItemService;

@RestController
@RequestMapping("/online/food")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    // Create a new cart item
    @PostMapping("/cartItem")
    public ResponseEntity<CartItemDto> addCartItem(@RequestBody CartItemDto cartItemDto) {
        CartItemDto savedCartItem = cartItemService.addCartItem(cartItemDto);
        return ResponseEntity.ok(savedCartItem);
    }

    // Get all cart items for a specific cart
    @GetMapping("/cart/{cartId}/items")
    public ResponseEntity<List<CartItemDto>> getCartItemsByCartId(@PathVariable long cartId) {
        List<CartItemDto> cartItems = cartItemService.getCartItemsByCartId(cartId);
        return ResponseEntity.ok(cartItems);
    }

    // Get a specific cart item by its ID
    @GetMapping("/cartItem/{id}")
    public ResponseEntity<CartItemDto> getCartItemById(@PathVariable long id) {
        return cartItemService.getCartItemById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update the quantity of a cart item
    @PutMapping("/cartItem/{id}")
    public ResponseEntity<CartItemDto> updateCartItemQuantity(@PathVariable long id, @RequestParam long quantity) {
        CartItemDto updatedCartItem = cartItemService.updateCartItemQuantity(id, quantity);
        return ResponseEntity.ok(updatedCartItem);
    }

    // Remove a cart item by its ID
    @DeleteMapping("/cartItem/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable long id) {
        cartItemService.removeCartItem(id);
        return ResponseEntity.noContent().build();
    }
}
