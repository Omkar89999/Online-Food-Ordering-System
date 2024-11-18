package com.food.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

    @Override
    Optional<Restaurant> findById(Long id);
}
