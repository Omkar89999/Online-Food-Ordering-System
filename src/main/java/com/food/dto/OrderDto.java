package com.food.dto;

import java.util.List;

import com.food.entity.OrderStatus;

import lombok.Data;

@Data
public class OrderDto {

    private Long userId;
    private List<Long> menuItemIds;
    private String deliveryAddress;
    private String paymentMethod;
    private Double totalPrice;
    private OrderStatus status;
}
