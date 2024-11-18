package com.food.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entity.CartItem;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long>{

	List<CartItem> findByCartId(long cartId);
}

