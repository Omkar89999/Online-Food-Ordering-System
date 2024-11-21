package com.food.service;

import java.util.List;

import com.food.dto.RestaurantDto;
import com.food.entity.Restaurant;

public interface ResturantInterface {

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    public RestaurantDto getRestaurantById(Long id);

    public RestaurantDto updateRestaurantById(RestaurantDto restaurantDto, Long id);

    public String deleteRestaurantById(long id);

    public List<Restaurant> getRestaurantsByLocation(String city);

    public List<Restaurant> getRestaurantsByRating(double minRating);
}
