package com.food.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entity.UserCart;
import com.food.entity.CartItem;
@Repository
public interface CartRepo extends JpaRepository<UserCart, Long>{

	Optional<UserCart> findById(UserCart id);
}