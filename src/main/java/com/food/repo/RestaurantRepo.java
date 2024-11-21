package com.food.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

    @Override
    Optional<Restaurant> findById(Long id);

    List<Restaurant> findByRatingGreaterThanEqual(Double rating);

    List<Restaurant> findByLocationCityContainingIgnoreCase(String city);
}
