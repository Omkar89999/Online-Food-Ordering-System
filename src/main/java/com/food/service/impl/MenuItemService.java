package com.food.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.MenuItemDto;
import com.food.entity.MenuItem;
import com.food.entity.Restaurant;
import com.food.repo.MenuItemRepo;
import com.food.repo.RestaurantRepo;
import com.food.service.MenuItemInterface;

import jakarta.transaction.Transactional;

@Service
public class MenuItemService implements MenuItemInterface {

    @Autowired
    private MenuItemRepo menuItemRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public MenuItem createMenuItem(MenuItemDto menuItemDto) {
        MenuItem menuItem = modelMapper.map(menuItemDto, MenuItem.class);

        Restaurant restaurantId = restaurantRepo.findById(menuItemDto.getRestaurant())
                .orElse(null);
        menuItem.setRestaurant(restaurantId);
        MenuItem savedMenuItem = menuItemRepo.save(menuItem);
        return savedMenuItem;
    }

    @Override
    public List<MenuItem> getMenuList(long id) {
        List<MenuItem> listOfMenu = menuItemRepo.findByRestaurantId(id);
        return listOfMenu;
    }

    @Override
    public MenuItem updateMenuItem(MenuItemDto menuItemDto, long id) {
        if (menuItemRepo.existsById(id)) {
            MenuItem menuItem = modelMapper.map(menuItemDto, MenuItem.class);
            Restaurant restaurant = restaurantRepo.findById(menuItemDto.getRestaurant())
                    .orElse(null);

            menuItem.setRestaurant(restaurant);
            menuItem.setId(id);
            MenuItem updatedMenuItem = menuItemRepo.save(menuItem);
            return updatedMenuItem;
        } else {
            return null;
        }
    }

    @Override
    public String deleteById(long id) {
        if (menuItemRepo.existsById(id)) {
            menuItemRepo.deleteById(id);

            return "Deleted Succesfully";
        }
        return "Resturant not found";
    }
}
