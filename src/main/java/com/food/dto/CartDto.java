package com.food.dto;

import java.util.List;

import com.food.entity.CartItem;
import com.food.entity.User;

import lombok.Data;
@Data
public class CartDto {

	
	private long id;
	
	private User user;
	
	private double total_price;
	
	 private List<CartItem> cartItems;

}
