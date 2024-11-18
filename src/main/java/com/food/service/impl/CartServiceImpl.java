package com.food.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.CartDto;
import com.food.dto.CartItemDto;
import com.food.entity.CartItem;
import com.food.entity.MenuItem;
import com.food.entity.UserCart;
import com.food.repo.CartItemRepo;
import com.food.repo.CartRepo;
import com.food.repo.MenuItemRepo;
import com.food.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private CartItemRepo cartItemRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MenuItemRepo menuItemRepo;


	// create or update cart
	@Override
	public CartDto createOrUpdateCart(long userId) {
		UserCart cart = cartRepo.findByUserId(userId).orElseThrow();
		UserCart createCart = cartRepo.save(cart);
		return this.modelMapper.map(createCart, CartDto.class);
	}
	
	@Override
	public CartItemDto addItemToCart(long cartId, long menuItemId, long quantity) {
	    // Fetch the existing cart by cartId or throw an exception if not found
	    UserCart cart = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

	    // Create CartItemDto and set properties manually
	    CartItemDto cartItemDto = new CartItemDto();
	    cartItemDto.setCart(cartId);  // Cart is already fetched, no need to save cart again
	    cartItemDto.setMenuItem(menuItemId);
	    cartItemDto.setQuantity(quantity);
	    cartItemDto.setPrice(calculatePrice(menuItemId, quantity)); // Calculate price for the item

	    // Map CartItemDto to CartItem and save it
	    CartItem cartItem = modelMapper.map(cartItemDto, CartItem.class);
	    cartItem.setCart(cart);  // Ensure the CartItem references the correct cart
	    cartItemRepo.save(cartItem);

	    // Update the total price of the cart
	    updateCartTotalPrice(cartId);

	    return cartItemDto; // Return CartItemDto or map it to CartDto as needed
	}


	@Override
	public double calculatePrice(long menuItemId, long quantity) {
	    Optional<MenuItem> menuItemOptional = menuItemRepo.findById(menuItemId);
	    if (menuItemOptional.isEmpty()) {
	        throw new IllegalArgumentException("Menu item not found with id: " + menuItemId);
	    }
	    MenuItem menuItem = menuItemOptional.get();
	    double unitPrice = menuItem.getPrice(); // Assuming MenuItem has a price field
	    return unitPrice * quantity;
	}


	private void updateCartTotalPrice(long cartId) {
		// Fetch the cart by its ID
		UserCart cart = cartRepo.findById(cartId).orElseThrow();

		// Calculate the total price by summing up the prices of all items in the cart
		double totalPrice = cart.getCartItems().stream().mapToDouble(CartItem::getPrice).sum();

		// Update the cart's total price and save the cart
		cart.setTotal_price(totalPrice);
		cartRepo.save(cart);
	}

	// Method to remove an item from the cart
	@Override
	public void removeItemFromCart(long cartItemId) {
		// Fetch the CartItem to get the CartId before deletion
		CartItem cartItem = cartItemRepo.findById(cartItemId).orElseThrow();

		// Get the CartId from the fetched CartItem
		long cartId = cartItem.getId();

		// Delete the CartItem from the repository
		cartItemRepo.deleteById(cartItemId);

		// Update the total price of the cart
		updateCartTotalPrice(cartId);
	}
	
	@Override
	public CartDto getCartByUserId(long userId) {
	    UserCart cart = cartRepo.findByUserId(userId)
	        .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));
	    return this.modelMapper.map(cart, CartDto.class);
	}


}
