package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDto {

    private long id;
    private long restaurant;
    private String name;
    private String description;
    private double price;
    private String imageurl;
}
