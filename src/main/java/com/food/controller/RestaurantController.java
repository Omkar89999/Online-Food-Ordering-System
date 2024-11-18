package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.RestaurantDto;
import com.food.service.impl.RestaurantService;

@RestController
@RequestMapping("/online/food/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/add")
    public RestaurantDto createRestaurant(@RequestBody RestaurantDto restaurantDTO) {
        return restaurantService.createRestaurant(restaurantDTO);
    }

    @GetMapping("/get/{id}")
    public RestaurantDto getMethodName(@PathVariable long id) {
        return restaurantService.getRestaurantById(id);
    }

    @PutMapping("update/{id}")
    public RestaurantDto putMethodName(@PathVariable long id, @RequestBody RestaurantDto restaurantDto) {
        return restaurantService.updateRestaurantById(restaurantDto, id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteRestaurantById(@PathVariable long id) {
        return restaurantService.deleteRestaurantById(id);
    }

}
