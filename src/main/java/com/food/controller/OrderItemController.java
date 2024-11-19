package com.food.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.entity.OrderItem;
import com.food.service.impl.OrderItemsService;

@RestController
@RequestMapping("/online/food/order")
public class OrderItemController {

    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping("/addorder")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemsService.addOrderItem(orderItem);
    }

    @GetMapping("/getorder/{id}")
    public List<OrderItem> getOrderItemsByItemId(@PathVariable long id) {
        return orderItemsService.getOrderItemsByItemId(id);
    }

    @GetMapping("/getorderbyid/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable long id) {
        return orderItemsService.getOrderItemById(id);
    }

    @GetMapping("/deleteOrderitems/{id}")
    public String deleteById(@PathVariable long id) {
        return orderItemsService.deleteOrderById(id);
    }

}
