package com.food.service;

import com.food.dto.RestaurantDto;

public interface ResturantInterface {

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    public RestaurantDto getRestaurantById(Long id);

    public RestaurantDto updateRestaurantById(RestaurantDto restaurantDto, Long id);

    public String deleteRestaurantById(long id);
}
