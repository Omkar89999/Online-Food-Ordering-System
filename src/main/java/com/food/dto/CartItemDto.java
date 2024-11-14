package com.food.dto;

import com.food.entity.UserCart;

import lombok.Data;
@Data
public class CartItemDto {

	private long id;

	private UserCart cart;

	private String menuItem;

	private long quantity;

	private double price;
}
