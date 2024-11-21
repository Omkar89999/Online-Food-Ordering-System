package com.food.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entity.OrderItem;

@Repository
public interface OrderItemsRepo extends JpaRepository<OrderItem, Long> {

    // Find all order items by order ID
    List<OrderItem> findByOrderId(Long orderId);

    // Find all order items by menu item ID (if needed)
    List<OrderItem> findByMenuItemId(Long menuItemId);
}
