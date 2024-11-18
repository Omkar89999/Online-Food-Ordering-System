package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

	private long id;

	private long cart;

	private long menuItem;

	private long quantity;

	private double price;

	public CartItemDto(long cartId, long menuItemId, long quantity) {
		super();
		this.cart = cartId;
		this.menuItem = menuItemId;
		this.quantity = quantity;
	}
	
	
}
