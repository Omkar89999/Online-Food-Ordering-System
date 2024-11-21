package com.food.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.OrderDto;
import com.food.entity.Order;
import com.food.entity.OrderStatus;
import com.food.entity.User;
import com.food.repo.OrderRepo;
import com.food.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper; // Inject ModelMapper

    // Create a new order from DTO
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);

        User userId = userRepo.findById(orderDto.getUserId()).orElse(null);

        if (userId != null) {
            order.setUserId(userId);
        }
        order = orderRepo.save(order);
        orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
    }

    // Update the status of an order
    @Transactional
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.setStatus(status);
        return orderRepo.save(order);
    }

    // Get an order by its ID
    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    // Delete an order
    @Transactional
    public void deleteOrder(Long orderId) {
        if (orderRepo.existsById(orderId)) {
            orderRepo.deleteById(orderId);
        } else {
            throw new IllegalArgumentException("Order not found");
        }
    }
}