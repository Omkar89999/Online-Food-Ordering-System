package com.food.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDto {

    private Long id;
    private long userId;
    private String orderStatus;
    private double orderPrice;
    private LocalDateTime dateTime;
}
