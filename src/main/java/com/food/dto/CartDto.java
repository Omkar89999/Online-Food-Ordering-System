package com.food.dto;

import com.food.entity.User;

import lombok.Data;
@Data
public class CartDto {

	
	private long id;
	
	private User user;
	
	private double total_price;
	

}
