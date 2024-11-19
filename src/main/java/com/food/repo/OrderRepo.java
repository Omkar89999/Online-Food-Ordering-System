package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
