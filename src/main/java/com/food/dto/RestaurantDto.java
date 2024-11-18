package com.food.dto;

import com.food.entity.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private String restaurantName;
    private Location location;
    private String description;
    private String rating;
}
