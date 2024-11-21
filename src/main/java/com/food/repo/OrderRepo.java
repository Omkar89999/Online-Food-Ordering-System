package com.food.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    // Find all orders by a specific customer (User object)
    // List<Order> findByUser(Long userId);

    // Find an order by its ID
    @Override
    Optional<Order> findById(Long id);

    // Find orders by status
    List<Order> findByStatus(String status);

    // Custom query to find orders based on delivery address
    List<Order> findByDeliveryAddressContaining(String deliveryAddress);

    // Custom query to find orders by payment method
    List<Order> findByPaymentMethod(String paymentMethod);
}
