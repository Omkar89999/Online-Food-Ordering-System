package com.food.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByRestaurantId(Long restaurant);

    List<MenuItem> findByNameContainingIgnoreCase(String name);
}
