package com.food.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.RestaurantDto;
import com.food.entity.Restaurant;
import com.food.repo.RestaurantRepo;
import com.food.service.ResturantInterface;

@Service
public class RestaurantService implements ResturantInterface {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        restaurant = restaurantRepo.save(restaurant);

        // Convert the saved Restaurant entity back to RestaurantDTO
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Optional<Restaurant> restaurantOpt = restaurantRepo.findById(id);
        return (RestaurantDto) restaurantOpt.map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class))
                .orElse(null); // Handle not found case
    }

    @Override
    public RestaurantDto updateRestaurantById(RestaurantDto restaurantDto, Long id) {
        // Optional<Restaurant> restaurantOpt =restaurantRepo.findById(id);
        // restaurantDto.
        if (restaurantRepo.existsById(id)) {
            Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
            restaurant.setId(id);
            Restaurant updateRestaurant = restaurantRepo.save(restaurant);
            return modelMapper.map(updateRestaurant, RestaurantDto.class);
        } else {
            return null;
        }
    }

    @Override
    public String deleteRestaurantById(long id) {
        if (restaurantRepo.existsById(id)) {
            restaurantRepo.deleteById(id);

            return "Deleted Succesfully";
        }
        return "Resturant not found";
    }

    @Override
    public List<Restaurant> getRestaurantsByLocation(String city) {
        return restaurantRepo.findByLocationCityContainingIgnoreCase(city);
    }

    @Override
    public List<Restaurant> getRestaurantsByRating(double minRating) {
        return restaurantRepo.findByRatingGreaterThanEqual(minRating);
    }
}
