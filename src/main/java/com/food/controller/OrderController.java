package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.OrderDto;
import com.food.service.impl.OrderService;

@RestController
@RequestMapping("/online/food/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public OrderDto placeOrder(@RequestBody OrderDto orderDto) {
        return orderService.placeOrder(orderDto);
    }

    @GetMapping("/getOrder/{id}")
    public OrderDto getOrder(@PathVariable long id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/updateOrder/{id}")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto, @PathVariable long id, @RequestParam String status) {
        return orderService.updateOrders(orderDto, id, status);
    }

}
