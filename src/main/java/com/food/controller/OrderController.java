package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.OrderDto;
import com.food.entity.Order;
import com.food.entity.OrderStatus;
import com.food.service.impl.OrderService;

@RestController
@RequestMapping("/online/food/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public OrderDto createOrder(@RequestBody OrderDto orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    // Update the status of an order
    @PutMapping("/update-status/{orderId}")
    public Order updateOrderStatus(@PathVariable Long orderId,
            @RequestParam OrderStatus status) {
        return orderService.updateOrderStatus(orderId, status);
    }

    // Get order by ID
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        // Order order = orderService.getOrderById(orderId);
        return orderService.getOrderById(orderId); // Convert to DTO before returning
    }

    // Delete an order
    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

}
