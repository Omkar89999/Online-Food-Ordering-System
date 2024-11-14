package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entity.CartItem;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long>{

}
