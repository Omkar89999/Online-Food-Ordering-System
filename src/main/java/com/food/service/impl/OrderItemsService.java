package com.food.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.entity.MenuItem;
import com.food.entity.OrderItem;
import com.food.repo.MenuItemRepo;
import com.food.repo.OrderItemsRepo;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepo orderItemsRepo;

    @Autowired
    private MenuItemRepo menuItemRepo;

    public OrderItem addOrderItem(OrderItem orderItem) {
        // Check if MenuItem exists before saving OrderItem
        Optional<MenuItem> menuItem = menuItemRepo.findById(orderItem.getMenuItem().getId());
        if (!menuItem.isPresent()) {
            throw new IllegalArgumentException("MenuItem does not exist with ID: " + orderItem.getMenuItem().getId());
        }

        return orderItemsRepo.save(orderItem);
    }

    public List<OrderItem> getOrderItemsByItemId(long itemsId) {
        return orderItemsRepo.findByOrderId(itemsId);
    }

    public Optional<OrderItem> getOrderItemById(long id) {
        return orderItemsRepo.findById(id);
    }

    public String deleteOrderById(long id) {
        if (orderItemsRepo.existsById(id)) {
            orderItemsRepo.deleteById(id);
        }

        return "Deleted Succesfully";
    }
}
