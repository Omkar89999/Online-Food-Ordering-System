package com.food.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.CartDto;
import com.food.dto.CartItemDto;
import com.food.entity.CartItem;
import com.food.entity.User;
import com.food.entity.UserCart;
import com.food.repo.CartRepo;
import com.food.repo.UserRepo;
import com.food.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

//	@Override
//	public CartDto createCart(CartDto cartDto) {
//		UserCart cart = this.modelMapper.map(cartDto, UserCart.class);
//		User user = userRepo.findById(cartDto.getUser()).orElseThrow();
//		cart.setUser(user);
//		UserCart createCart = cartRepo.save(cart);
//		return this.modelMapper.map(createCart, CartDto.class);
//	}
	
	// create or update cart
	
	 public CartDto createOrUpdateCart(int userId) {
	        UserCart cart = cartRepo.findByUserId(userId).orElseThrow();  
	        UserCart createCart = cartRepo.save(cart);
	        return this.modelMapper.map(createCart, CartDto.class);
	    }

	  public CartItemDto addItemToCart(int cartId, int menuItemId, int quantity) {
		  return null;
	  }
//	@Override
//	public CartDto updateCart(CartDto cartDto, Long id) {
//		UserCart cart = this.cartRepo.findById(id).orElseThrow();
//		cart.setUser(cartDto.getUser());
//		cart.setTotal_price(cartDto.getTotal_price());
//		cart.setCartItems(cartDto.getCartItem);
//		UserCart updatedCart = cartRepo.save(cart);
//		return this.modelMapper.map(updatedCart, CartDto.class);
//	}

//	@Override
//	public CartDto updateCart(CartDto cartDto, Long id) {
//		// Fetch the existing cart or throw an exception
//		UserCart cart = this.cartRepo.findById(id).orElseThrow(); // Use your custom exception
//
//		// Update cart details
//		cart.setUser(this.modelMapper.map(cartDto.getUser(), User.class)); // Ensure User mapping
//		cart.setTotal_price(cartDto.getTotal_price());
//
//		// Map and set cart items
//		List<CartItem> cartItems = cartDto.getCartItems().stream()
//				.map(cartItemDto -> this.modelMapper.map(cartItemDto, CartItem.class)).collect(Collectors.toList());
//		cart.setCartItems(cartItems);
//
//		// Save the updated cart and return the DTO
//		UserCart updatedCart = cartRepo.save(cart);
//		return this.modelMapper.map(updatedCart, CartDto.class);
//	}


	@Override
	public List<CartDto> getAllCart() {
		List<UserCart> allCart = this.cartRepo.findAll();

		return allCart.stream().map(cartItem -> this.modelMapper.map(cartItem, CartDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public CartDto getCartById(Long id) {
		UserCart cart = cartRepo.findById(id).orElseThrow();
		return modelMapper.map(cart, CartDto.class);
	}

	@Override
	public void deleteCart(Long id) {
		UserCart cart = cartRepo.findById(id).orElseThrow();
		this.cartRepo.delete(cart);
	}

}
